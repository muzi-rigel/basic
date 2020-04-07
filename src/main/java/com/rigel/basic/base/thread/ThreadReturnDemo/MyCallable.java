package com.rigel.basic.base.thread.ThreadReturnDemo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call(){
        String value = "";

        System.out.println("task start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "ready to wait!";
        System.out.println("task down....");

        return value;
    }
}
