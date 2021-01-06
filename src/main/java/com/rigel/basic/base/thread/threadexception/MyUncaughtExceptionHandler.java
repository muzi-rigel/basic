package com.rigel.basic.base.thread.threadexception;

// 实现Thread.UncaughtExceptionHandler 接口，创建异常处理器
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " caught " + e);
    }
}
