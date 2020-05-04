package com.rigel.basic.base.collections.Queue.BlockingQueueDemo;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue bq;

    public Consumer(BlockingQueue bq) {
        this.bq = bq;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Thread.sleep(1000);
                Object obj = bq.take();
                System.out.println("消费完成，队列长度变为" + bq.size());
                System.out.println("消费对象-->" + obj);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
