package com.rigel.basic.base.concurrent;

import java.util.concurrent.Semaphore;

public class HelloSemaphore {

    public static void main(String[] args) {
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(2, true);
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);

        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T1 running...");
                Thread.sleep(1000);
                System.out.println("T1 running over...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T2 running...");
                Thread.sleep(1000);
                System.out.println("T2 running over...");

                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                s.acquire();

                System.out.println("T3 running...");
                Thread.sleep(1000);
                System.out.println("T3 running over...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();
    }

}
