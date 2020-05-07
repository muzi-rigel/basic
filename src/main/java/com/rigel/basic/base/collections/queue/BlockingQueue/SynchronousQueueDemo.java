package com.rigel.basic.base.collections.queue.BlockingQueue;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>(true);

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread putThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread2 start");
                try {
                    queue.put(2);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread2 end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        Thread takeThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread2 start");
                try {
                    System.out.println("take2 from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread2 end");
            }
        });

        putThread.start();
        Thread.sleep(500);
        putThread2.start();
        Thread.sleep(2000);
        takeThread.start();
        Thread.sleep(2000);
        takeThread2.start();

    }
}
