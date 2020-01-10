package com.rigel.basic.base.Thread.notifydemo;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifyTest {

    public static void main(String[] args) throws Exception {
        List<Integer> cache = new ArrayList<>();
        new Thread(new Consumer(cache)).start();
        new Thread(new Producer(cache)).start();
    }

}
