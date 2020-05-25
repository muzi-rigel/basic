package com.rigel.basic.base.thread.threadstatedemo;

public class ThreadStateDemo {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        showState(t);

        t.start();
        showState(t);
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

        showState(t);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        t.interrupt();

        showState(t);



    }

    private static void showState(Thread t) {
        System.out.println(t.getState());
    }

}
