package com.rigel.basic.base.concurrent.unsagedemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Person {

    private volatile int i2;
    private int i = 0;

    private static Boolean flag = true;

    private static sun.misc.Unsafe UNSAFE;
    private static long I_OFFSET;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);

            System.out.println(UNSAFE);

            I_OFFSET = UNSAFE.objectFieldOffset(Person.class.getDeclaredField("i"));

            System.out.println(I_OFFSET);


            UNSAFE.getObjectVolatile(11,11l);


        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Person(int i) {
        this.i = i;
    }

    public Person() {

    }

    public static void main(String[] args) {
        Person person = new Person();

        Thread thread1 = new Thread() {
            public void run() {
                while (flag) {
                    boolean result = UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i + 1);
                    if(result){
//                        System.out.println("cas success");
                    }else {
//                        System.out.println("cas fail");
                        flag = false;
                        throw new Error("Waiting for you !");
                    }
                    System.out.println(UNSAFE.getIntVolatile(person,I_OFFSET));
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                while (flag) {
                    boolean result = UNSAFE.compareAndSwapInt(person, I_OFFSET, person.i, person.i + 1);
                    if(result){
//                        System.out.println("cas success");
                    }else {
//                        System.out.println("cas fail");
                        flag = false;
                        throw new Error("Waiting for you !");
                    }
                    System.out.println(UNSAFE.getIntVolatile(person,I_OFFSET));
//                    try {
//                        Thread.sleep(200);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };

        thread1.start();
        thread2.start();


    }
}

