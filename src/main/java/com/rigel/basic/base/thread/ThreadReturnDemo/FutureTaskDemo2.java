package com.rigel.basic.base.thread.ThreadReturnDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo2 {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(100);
                return Math.random();
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();

        while (!futureTask.isDone()) {
            System.out.println("waiting ..");
            TimeUnit.MILLISECONDS.sleep(30);
        }
        System.out.println("result ==" + futureTask.get());
        System.out.println(futureTask.isDone());
    }
}
