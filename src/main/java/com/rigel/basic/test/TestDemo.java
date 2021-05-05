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
    /*
      int和integer比较大小
     */
    public void test14(){
        int a=257;
        Integer b=257;
        Integer c=257;
        Integer b2=57;
        Integer c2=57;
        System.out.println(a==b);     //true
//System.out.println(a.equals(b));  编译出错，基本型不能调用equals()
        System.out.println(b.equals(257.0)); //false
        System.out.println(b==c);      //false
        System.out.println(b2==c2);     //true
    }

    @Test
    public void test13(){
        float a = (float) 0.2;
        float b = 0.2f;
        double c = 0.2;
        double d = 0.2d;
        Float t = 20.5f;
        int i = Float.floatToIntBits(t);
        t.equals(a);
        System.out.println(i);
    }

    @Test
    public void test12() {
        int a = 5;
        int b = 10;
        System.out.println("a=" + a + " b=" + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a=" + a + " b=" + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a=" + a + " b=" + b);


    }

    @Test
    public void test11() {
        int data[] = null;
        data = new int[3]; //开辟一个长度为3的数组
        int b[] = new int[3];
        int temp[] = null; //声明对象
        data[0] = 10;
        data[1] = 20;
        data[2] = 30;
        temp = data;  //int temp[] = data;
        temp[0] = 99;
        for (int i = 0; i < temp.length; i++) {
            System.out.println(data[i]);
        }
    }


    @Test
    public void test10() {
        int a = 0;
        int b = 1;
        int c = 2;

        a = b = c;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    public void test9() {

        while (true) {
            int random = (int) (Math.random() * 100);
            System.out.println(random);
            if (random > 90)
                break;
        }
    }

    @Test
    public void test8() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
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
    public void test7() {
        AtomicInteger i = new AtomicInteger(5);
        System.out.println(i.incrementAndGet());
    }

    @Test
    public void test6() {
//        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    @Test
    public void test5() {
        int a = (a = 16 << 1);
        System.out.println(a);
    }

    @Test
    public void test4() {
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
                System.out.println("take=" + take);
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

