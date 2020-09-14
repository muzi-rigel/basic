package com.rigel.basic.base.juc.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockDemo3 {

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void lockTest() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " try lock");
        lock.lock();
        System.out.println(name + " locked");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " unlock");
        lock.unlock();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(ReentrantlockDemo3::lockTest);
        thread.setName("t1");
        thread.start();

        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lockTest();
    }
}
