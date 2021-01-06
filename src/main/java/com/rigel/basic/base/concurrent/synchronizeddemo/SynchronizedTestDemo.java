package com.rigel.basic.base.concurrent.synchronizeddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class SynchronizedTestDemo {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                Muzi.print();
//                new Muzi().print2();
            }
        };

        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r1, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
//                Muzi.print();
                Muzi.print3();
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();


        FutureTask tt1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                return 1 + 1;
            }
        });
        new Thread(tt1).start();
        try {
            System.out.println(tt1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class Muzi {

    public static synchronized void print() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-print");
    }

    public synchronized void print2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-print2");
    }

    public synchronized static void print3() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-print3");
    }
}



