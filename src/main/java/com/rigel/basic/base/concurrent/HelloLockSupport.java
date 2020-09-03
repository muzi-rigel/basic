package com.rigel.basic.base.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class HelloLockSupport {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    LockSupport.park();
                }
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t.start();

        LockSupport.unpark(t);

//        try {
//            TimeUnit.SECONDS.sleep(8);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("after 8 senconds!");
//
//        LockSupport.unpark(t);

    }
}
