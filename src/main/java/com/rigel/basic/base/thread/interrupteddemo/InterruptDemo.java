package com.rigel.basic.base.thread.interrupteddemo;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable interruptTask = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Thread.sleep(100);
                        i++;
                        System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getState()+") loop="+i);
                    }
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException exception");
                }
            }
        };

        Thread t1 = new Thread(interruptTask,"t1");
        System.out.println(t1.getName()+"-new-"+t1.getState());
        t1.start();
        System.out.println(t1.getName()+"-start-"+t1.getState());
        Thread.sleep(500);
        t1.interrupt();
        System.out.println(t1.getName()+"-interrupt-"+t1.getState());
        Thread.sleep(300);
        System.out.println(t1.getName()+"-interrupted-"+t1.getState());

    }

}
