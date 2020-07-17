package com.rigel.basic.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class TestDemo {

    private ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    @Test
    public void test9(){

        while(true){
            int random = (int) (Math.random()*100);
            System.out.println(random);
            if(random > 90)
                break;
        }
    }

    @Test
    public void test8(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("1");
                    throw new Error("error");
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main thread is still alive!");
    }


    @Test
    public void test7(){
        AtomicInteger i = new AtomicInteger(5);
        System.out.println(i.incrementAndGet());
    }

    @Test
    public void test6(){
//        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    @Test
    public void test5(){
        int a = (a = 16 << 1);
        System.out.println(a);
    }

    @Test
    public void test4(){
        Integer integer = local.get();
        System.out.println(integer);
    }

    @Test
    public void test3() throws InterruptedException {
        SynchronousQueue queue = new SynchronousQueue();
        Object o = queue.remove();
        queue.add("a");
        //都抛异常。。
        System.out.println(o);
    }

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
                System.out.println("take="+take);
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

