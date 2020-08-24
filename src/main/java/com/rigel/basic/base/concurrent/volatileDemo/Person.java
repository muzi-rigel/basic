package com.rigel.basic.base.concurrent.volatileDemo;

public class Person {

    private volatile int i2;
    private int i;


    public static void main(String[] args) {
        Person person = new Person();

        Thread thread1 = new Thread(){
          public void run(){
              while (true){
                  System.out.println(person.i++);
                  try {
                      Thread.sleep(500);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
          }
        };

        Thread thread2 = new Thread(){
            public void run(){
                while (true){
                    System.out.println(person.i++);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.start();
        thread2.start();


    }
}
