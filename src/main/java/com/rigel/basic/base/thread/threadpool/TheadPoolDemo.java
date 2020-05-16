package com.rigel.basic.base.thread.threadpool;

import java.util.concurrent.*;

public class TheadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService service2 = Executors.newCachedThreadPool();

//        ThreadPoolExecutor service = new ThreadPoolExecutor(1, 1,
//                60L, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>());

//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        executorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("delay 3 seconds");
//            }
//        }, 1, 3, TimeUnit.SECONDS);

//        Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"--> in");
                        Thread.sleep(60);
                        System.out.println(Thread.currentThread().getName()+"--> out");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        service.shutdown();
    }
}
