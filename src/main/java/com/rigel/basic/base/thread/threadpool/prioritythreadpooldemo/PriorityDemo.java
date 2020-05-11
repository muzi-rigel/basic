package com.rigel.basic.base.thread.threadpool.prioritythreadpooldemo;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityDemo {
    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                2,
                Long.MAX_VALUE, /* timeout */
                TimeUnit.NANOSECONDS,
                new PriorityBlockingQueue<Runnable>(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        PrioritizedRunnable p1 = new PrioritizedRunnable(1234, "name1-1");
        PrioritizedRunnable p2 = new PrioritizedRunnable(1500, "name4-2");
        PrioritizedRunnable p3 = new PrioritizedRunnable(1590, "name5-3");
        PrioritizedRunnable p4 = new PrioritizedRunnable(1490, "name3-4");
        PrioritizedRunnable p5 = new PrioritizedRunnable(1290, "name2-5");

        executor.execute(p1);
        executor.execute(p2);
        executor.execute(p3);
        executor.execute(p4);
        executor.execute(p5);

//        executor.execute(p5);
//        executor.execute(p4);
//        executor.execute(p3);
//        executor.execute(p2);
//        executor.execute(p1);

        System.out.println("submit 5 Runnable");
        Thread.sleep(3*1000);
        executor.shutdown();
        System.out.println("done!");
    }
}
