package com.rigel.basic.base.thread.NotificationDemo;

public class NotificationDemo {
    // 设置volatile类型的标志
    private volatile boolean go = false;

    private synchronized void shouldGo() throws InterruptedException {
        while(!go){
            System.out.println(Thread.currentThread()
                    + "正在执行wait()");
            wait();
            System.out.println(Thread.currentThread() + " 被唤醒");
        }
        go = false;
    }

    private synchronized void go() {
        while (!go){
            System.out.println(Thread.currentThread()
                    + " 唤醒当前对象的一个或多个线程");

            go = true;
//             notify();
            notifyAll();
        }

    }

    public static void main(String args[]) throws InterruptedException {
        final NotificationDemo test = new NotificationDemo();

        Runnable waitTask = new Runnable(){

            @Override
            public void run(){
                try {
                    test.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 完成执行");
            }
        };

        Runnable notifyTask = new Runnable(){

            @Override
            public void run(){
                test.go();
                System.out.println(Thread.currentThread().getName() + " 完成执行");
            }
        };

        Thread t1 = new Thread(waitTask, "WT1"); //will wait
        Thread t2 = new Thread(waitTask, "WT2"); //will wait
        Thread t3 = new Thread(waitTask, "WT3"); //will wait
        Thread t4 = new Thread(notifyTask,"NT1"); //will notify

        // 开始线程等待
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(200);

        // 开始唤醒线程
        t4.start();

    }
}
