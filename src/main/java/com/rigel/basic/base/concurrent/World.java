package com.rigel.basic.base.concurrent;

public class World {

    public static void main(String[] args) {
        Thread t1 = new myThread1();
        Thread t2 = new myThread2();
        t1.start();
        t2.start();
    }

}


class myThread1 extends Thread{
    public void run(){
        try {
            System.out.println("我是线程1，age为" + Person.age);
            Thread.sleep(1000);
            System.out.println("我是线程1，age现在为" + Person.age);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class myThread2 extends  Thread{
    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("我是线程2，age现在为" + Person.age +"进行修改");
            Person.age = 30;
            System.out.println("我是线程2，age现在为" + Person.age +"修改完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}