package com.rigel.basic.base.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    private static volatile int i = 0;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        //synchronized (TestReentrantLock.class) {
        i++;
        //}

        lock.unlock();

        //synchronized 程序员的丽春院 JUC
    }
}