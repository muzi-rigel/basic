package com.rigel.basic.base.concurrent.interview2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLockTest1 {


    public static final String START = " try to get lock";
    public static final String SUCCESS = " get lock successfully";
    public static final String UNLOCK = "unlock";
    public static final String AWAIT = " await";
    public static final String CONSUME = "consume";

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                showLock(lock, START);
                lock.lock();
                showLock(lock, SUCCESS);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showLock(lock, UNLOCK);
                lock.unlock();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(r);
            t.setName("t" + i);
            t.start();
        }

    }

    private static void showLock(ReentrantLock lock, String s) {
        System.out.println(Thread.currentThread().getName() + " - " + lock + s);
    }

}
