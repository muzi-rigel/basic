package com.rigel.basic.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.SynchronousQueue;


public class TestDemo {

    @Test
    public void test1() throws Exception {
        SynchronousQueue workQueue = new SynchronousQueue();


        new Thread(new Runnable() {
            @Override
            public void run() {
                Object take = null;
                try {
                    take = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(take);
            }
        }).start();

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean a = workQueue.offer("a");
        System.out.println(a);
        boolean b = workQueue.offer("b");
        System.out.println(b);

    }

    @Test
    public void test2() throws Exception {
        System.out.println(1 & 1);
        System.out.println(1 & 0);
        System.out.println(0 & 0);
        System.out.println(0 & 1);
        System.out.println("-----------");
        System.out.println(1 | 1);
        System.out.println(1 | 0);
        System.out.println(0 | 0);
        System.out.println(0 | 1);
        System.out.println("-----------");
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println("----------");


        File file = new File("C:\\Users\\Lenovo\\Desktop\\World.java");
        FileInputStream fis = new FileInputStream(file);
        byte[] bs = new byte[(int) file.length()];
        fis.read(bs);
        for (byte b : bs) {
            System.out.println(b);
        }
        fis.close();


    }
}

