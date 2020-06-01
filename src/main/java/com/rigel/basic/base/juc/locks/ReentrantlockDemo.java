package com.rigel.basic.base.juc.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockDemo implements Runnable {

    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantlockDemo demo = new ReentrantlockDemo();
        Thread thread1 = new Thread(demo);
        Thread thread2 = new Thread(demo);
        thread1.start();
        thread2.start();
    }
}
