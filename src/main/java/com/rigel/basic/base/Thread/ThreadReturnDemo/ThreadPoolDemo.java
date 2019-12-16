package com.rigel.basic.base.Thread.ThreadReturnDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> task = service.submit(new MyCallable());
        if(!task.isDone()){
            System.out.println("task is running!");
        }
        try {
            System.out.println("result is --->" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
        System.out.println(task.isDone());
    }
}
