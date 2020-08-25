package com.rigel.basic.base.concurrent.containerdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 面试题——实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，
 * 线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 */
//demo2 demo1中加入volatile 但未上锁可能另一个线程+1到6才完整break 另外浪费cpu
public class ContainerDemo2 {

    volatile List lists = new ArrayList();

    public boolean add(Object e) {
        return lists.add(e);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        ContainerDemo2 demo = new ContainerDemo2();

        new Thread(() -> {
            while (true){
                if(demo.size() >= 5){
                    break;
                }
            }
            System.out.println("t2线程结束啦 ");
        },"t2").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                demo.add(i);
                System.out.println("add" + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();
        System.out.println(demo.lists);
    }
}
