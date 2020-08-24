package com.rigel.basic.base.concurrent;

public class World2 {

    public static void main(String[] args) {
        Person p = new Person();
        Thread t1 = new myThread3(p);
        Thread t2 = new myThread4(p);
        t1.start();
        t2.start();
    }

}


class myThread3 extends Thread{

    Person p = null;

    public myThread3(Person person) {
        p = person;
    }

    public void run(){
        try {
            System.out.println("我是线程1，count为" + p.count);
            Thread.sleep(1000);
            System.out.println("我是线程1，count现在为" + p.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class myThread4 extends  Thread{
    Person p = null;

    public myThread4(Person person) {
        p = person;
    }

    public void run(){
        try {
            Thread.sleep(500);
            System.out.println("我是线程2，count为" + p.count);
            p.count = 1;
            System.out.println("我是线程2，count修改后为" + p.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}