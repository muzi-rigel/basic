package com.rigel.basic.base.collections.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
    public static void main(String[] args) {
        System.out.println("测试开始---");
        new Thread("Thread1"){
            @Override
            public void run() {
                map.put(3, 33);

            }
        }.start();

        new Thread("Thread2"){
            @Override
            public void run() {
                map.put(4, 44);

            }
        }.start();

        new Thread("Thread3"){
            @Override
            public void run() {
                map.put(7, 77);

            }
        }.start();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

}
