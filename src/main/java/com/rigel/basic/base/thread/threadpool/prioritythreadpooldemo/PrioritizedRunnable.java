package com.rigel.basic.base.thread.threadpool.prioritythreadpooldemo;

import java.util.Random;

public class PrioritizedRunnable implements Runnable, Comparable<PrioritizedRunnable> {
    private long rts;
    private String name;

    PrioritizedRunnable(long rts, String name) {
        this.rts = rts;
        this.name = name;
    }

    public long getRts() {
        return rts;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(PrioritizedRunnable secondOne) {
        // 时间越小越优先
        System.out.println("compareTo. this.name={" + this.getName() + "}, secondOne.name={" + secondOne.getName() + "}");
        if (this.getRts() < secondOne.getRts()) {
            return -1;
        } else if (this.getRts() > secondOne.getRts()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("rts=" + rts + " name=" + name);
        try {
            int sleepRandom = random.nextInt(200) + 100;
            Thread.sleep(sleepRandom);
        } catch (Exception ex) {
            System.out.println("sleep exception--" + ex);
        }
    }
}
