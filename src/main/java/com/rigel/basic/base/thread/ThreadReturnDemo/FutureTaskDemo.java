package com.rigel.basic.base.thread.ThreadReturnDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()){
            System.out.println("task is running!");
        }
        System.out.println("result is --->" + task.get());
        System.out.println(task.isDone());
    }
}
