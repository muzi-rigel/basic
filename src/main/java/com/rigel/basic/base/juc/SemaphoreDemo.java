package com.rigel.basic.base.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    //在 semaphore.acquire() 和 semaphore.release()之间的代码，同一时刻只允许制定个数的线程进入，
    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        //模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index + 1;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
//                      在 semaphore.acquire() 和 semaphore.release()之间的代码，同一时刻只允许制定个数的线程进入，
                        //获取许可
                        semp.acquire();
                        System.out.println("-->Accessing -->" + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        //访问完后 释放
                        System.out.println("<--Releasing -->" + NO);
                        semp.release();
                    }catch (Exception e){

                    }
                }
            };
            exec.execute(run);
        }
        exec.shutdown();
    }
}
