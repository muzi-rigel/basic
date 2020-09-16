package com.rigel.basic.base.thread.ThreadReturnDemo;

import java.util.concurrent.Callable;

public class CallableDemo {

    public static void main(String[] args) throws Exception {

        Callable call = new Callable() {
            @Override
            public Object call() throws Exception {
                int y = 2 + 2;
                return y;
            }
        };
        Object o = call.call();
        System.out.println(o);

    }
}
