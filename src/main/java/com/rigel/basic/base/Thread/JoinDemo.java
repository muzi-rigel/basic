package com.rigel.basic.base.Thread;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new myThread());
        t1.start();
        t1.join();
        System.out.println("Main end");
    }
}

class myThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("myThread end");
    }
}
