package com.rigel.basic.base.thread.notifydemo;

import java.util.List;

public class Consumer implements Runnable {
    List<Integer> cache;

    public Consumer(List<Integer> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    private void consume() {
        synchronized (cache) {
            try {
                while (cache.isEmpty()) {
                    System.out.println("--consumer into wait--");
                    cache.wait();
                }

                System.out.println("Consumer consumed [" + cache.remove(0) + "]");
                System.out.println("--consumer notify--");
                cache.notify();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
