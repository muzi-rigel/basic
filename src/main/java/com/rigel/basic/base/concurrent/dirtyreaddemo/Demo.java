package com.rigel.basic.base.concurrent.dirtyreaddemo;

//没认真看demo 以为发现了新大陆。。
public class Demo {

    String name;
    double banlance;

    public synchronized void set(String name, double banlance){
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.banlance = banlance;
    }

    public double getBanlance(String name){
        return this.banlance;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(()->demo.set("muzi",100.0)).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(demo.getBanlance("muzi"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(demo.getBanlance("muzi"));

    }
}
