package com.rigel.basic.base.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * exchanger只能用于两个线程交换数据
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        final Exchanger exchanger = new Exchanger();
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String girl = (String) exchanger.exchange("其实我喜欢你很久了。。");
                    System.out.println("女生说:" + girl);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String boy = (String) exchanger.exchange("我也喜欢你呀。。");
                    System.out.println("男生说:" + boy);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.shutdown();
    }
}
