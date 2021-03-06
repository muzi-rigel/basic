package com.rigel.basic.base.thread.communicationsdemo;

public class Breads {
    //面包的id
    private int bid;
    //面包的个数
    private int num;

    //生产面包的方法（由于是demo，方便大家理解，就把synchronized关键字加到方法上面了哦）
    public synchronized void produc() {

        //当面包的数量不为0时，该方法处于等待状态
        //多对多的时候 while
        while (0 != num) {
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //当面包数量为0时，那么就开始生产面包了哦
        num = num + 1;//数量加1
        bid = bid + 1;//id当然也得加1
        String threadname = Thread.currentThread().getName();
        System.out.println(threadname + "生产了一个编号为" + bid + "的面包！个数为" + num);
        notifyAll();//当执行完后，去唤醒其他处于等待的线程

    }

    //消费面包的方法
    public synchronized void consume() {
        //当面包的数量为0时，该方法处于等待状态
        //多对多的时候  while
        while (num == 0) {
            try {
                wait();//等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费完面包了，所以面包数量降为0了
        num = num - 1;//数量减1
        String name1 = Thread.currentThread().getName();
        System.out.println(name1 + "买了一个面包编号为" + bid + "个数为" + num);
        notifyAll();//当执行完后，去唤醒其他处于等待的线程
        //多对多的时候notifyAll()
    }

    //有参构造
    public Breads(int bid, int num) {
        super();
        this.bid = bid;
        this.num = num;
    }

    //无参构造
    public Breads() {
        super();
    }
}
