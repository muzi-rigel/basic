package com.rigel.basic.base.Thread.notifydemo;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable{
    List<Integer> cache;

    public Producer(List<Integer> cache) {
        this.cache = cache;
    }

    @Override
    public void run() {
        while (true) {
            produce();
        }
    }

    private void produce() {
        synchronized (cache) {
            try {
                while (cache.size() == 1) {
                    System.out.println("--producer into wait--");
                    cache.wait();
                }

                // 模拟一秒生产一条消息
                Thread.sleep(1000);
                cache.add(new Random().nextInt());
                System.out.println("--producer notify--");
                cache.notify();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
