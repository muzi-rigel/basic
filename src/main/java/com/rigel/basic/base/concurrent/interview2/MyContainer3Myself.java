package com.rigel.basic.base.concurrent.interview2;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyContainer3Myself<T> {

    private static final int MAX = 10;

    List lists = new LinkedList();

    public static void main(String[] args) throws InterruptedException {
        MyContainer3Myself my = new MyContainer3Myself();

        ReentrantLock lock = new ReentrantLock();
        Condition consumerLock = lock.newCondition();
        Condition producerLock = lock.newCondition();

        Runnable producerR = (new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                while (my.lists.size() >= MAX) {
                    try {
                        producerLock.await();
                        System.out.println(Thread.currentThread().getName() + " await");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                my.lists.add("a");
                System.out.println(Thread.currentThread().getName() + " product");
                consumerLock.signalAll();
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock");
            }
        });
        Runnable consumerR = (() -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get lock");
            while (my.lists.size() == 0) {
                try {
                    consumerLock.await();
                    System.out.println(Thread.currentThread().getName() + " await");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            my.lists.remove(0);
            System.out.println(Thread.currentThread().getName() + " consume");
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
}
