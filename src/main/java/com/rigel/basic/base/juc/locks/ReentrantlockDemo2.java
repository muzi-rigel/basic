package com.rigel.basic.base.juc.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantlockDemo2 implements Runnable {

    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        try {
            lock.lock();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new ReentrantlockDemo2()).start();
    }
}
