package com.rigel.basic.base.collections.Queue.BlockingQueue.BlockingQueueDemo;

import java.util.concurrent.*;

public class ProducerConsumerExample {


    public static void main(String[] args) throws InterruptedException {
        int numProducers = 4;
        int numConsumers = 3;

        BlockingQueue<Object> myQueue = new LinkedBlockingDeque<>();

        for (int i = 0; i < numProducers; i++) {
            new Thread(new Producer(myQueue)).start();
        }

        for (int i = 0; i < numConsumers; i++) {
            new Thread(new Consumer(myQueue)).start();
        }

        Thread.sleep(2000);

        System.exit(0);
    }
}
