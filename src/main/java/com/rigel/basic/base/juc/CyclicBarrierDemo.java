package com.rigel.basic.base.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    //假设有一家公司要全体员工进行团建活动，活动内容为翻越三个障碍物，
    // 每一个人翻越障碍物所用的时间是不一样的。
    // 但是公司要求所有人在翻越当前障碍物之后再开始翻越下一个障碍物，
    // 也就是所有人翻越第一个障碍物之后，才开始翻越第二个，以此类推。
    // 类比地，每一个员工都是一个“其他线程”。当所有人都翻越的所有的障碍物之后，程序才结束。
    // 而主线程可能早就结束了，这里我们不用管主线程。

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        for (int i = 0; i < barrier.getParties(); i++) {
            new Thread(new MyRunnable(barrier), "队友" + i).start();
        }
        System.out.println("main function is finished.");
    }


    private static class MyRunnable implements Runnable {
        private CyclicBarrier barrier;

        public MyRunnable(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Random rand = new Random();
                    int randomNum = rand.nextInt((6000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                    Thread.sleep(randomNum);
                    System.out.println(Thread.currentThread().getName() + ", 通过了第" + (i + 1) + "个障碍物, 使用了 " + ((double) randomNum / 1000) + "s");
                    this.barrier.await();
                    System.out.println(Thread.currentThread().getName() + "开始新的比赛");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
