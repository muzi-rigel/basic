package com.rigel.basic.base.thread.threadexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor(new HandlerThreadFactory());
        service.execute(new ExceptionThread2());


    }
}
