package com.rigel.basic.base.concurrent.containerdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题——实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，
 * 线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 */
//demo3 因为t1 notify不释放锁 所以还得await释放
public class ContainerDemo3 {

    private volatile List lists = new ArrayList();

    public boolean add(Object e) {
        return lists.add(e);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        ContainerDemo3 demo = new ContainerDemo3();
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2启动");
                if (demo.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2线程结束啦 ");
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1启动");
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    demo.add(i);
                    System.out.println("add" + i);
                    if (demo.size() == 5) {
                        lock.notify();
                        try {
//                            因为notify不释放锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }
}
