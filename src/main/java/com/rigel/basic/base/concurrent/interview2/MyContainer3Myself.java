package com.rigel.basic.base.concurrent.interview2;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer3Myself<T> {

    private static final int MAX = 10;
    public static final String START = " try to get lock";
    public static final String SUCCESS = " get lock successfully";
    public static final String UNLOCK = " unlock";
    public static final String AWAIT = " await";
    public static final String CONSUME = " consume-";
    public static final String PRODUCT = " product-";

    List lists = new LinkedList();

    public static void main(String[] args) throws InterruptedException {
        MyContainer3Myself my = new MyContainer3Myself();

        ReentrantLock lock = new ReentrantLock();
        Condition consumerLock = lock.newCondition();
        Condition producerLock = lock.newCondition();

        Runnable producerR = (new Runnable() {
            @Override
            public void run() {
                showLock(lock, START);
                lock.lock();
                showLock(lock, SUCCESS);
                while (my.lists.size() >= MAX) {
                    try {
                        producerLock.await();
                        showLock(lock, AWAIT);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object o = "a";
                System.out.println(Thread.currentThread().getName() + PRODUCT + o);
                my.lists.add(o);
                consumerLock.signalAll();
                showLock(lock, UNLOCK);
                lock.unlock();
            }

        });
        Runnable consumerR = (() -> {
            showLock(lock, START);
            lock.lock();
            showLock(lock, SUCCESS);
            while (my.lists.size() == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + AWAIT);
                    consumerLock.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object o = my.lists.remove(0);
            System.out.println(Thread.currentThread().getName() + CONSUME + o);
            producerLock.signalAll();
            lock.unlock();
        });

        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(consumerR);
            t.setName("consumer-" + i);
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(producerR);
            t.setName("product-" + i);
            t.start();
        }

        Thread.sleep(100000);

    }

    private static void showLock(ReentrantLock lock, String s) {
        System.out.println(Thread.currentThread().getName() + " - " + lock + s);
    }
}
