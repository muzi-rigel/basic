package com.rigel.basic.base.collections.queue.BlockingQueue.BlockingQueueDemo;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue bq;

    public Producer(BlockingQueue bq) {
        this.bq = bq;
    }

    @Override
    public void run() {

        try {
            while (true) {
                Object justConsumed = getResource();
                bq.put(justConsumed);
                System.out.println("已插入，队列长度为-->" + bq.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Object getResource() throws InterruptedException {

        Thread.sleep(100);
        return new Object();
    }
}
