package com.rigel.basic.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Methods {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static int random(int max) {
        return random(0, max);
    }

    public static int random(int min, int max) {
        return min + new Random().nextInt(max - min + 1);
    }

    public static void doingLongTime() {
        int second = random(5, 10);
        sleep(second);
    }

    public static void doingLongTime(int second) {
        sleep(second);
    }

    public static void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep2(int second) throws InterruptedException {
        TimeUnit.SECONDS.sleep(second);
    }

    public static void println3(Object obj) {
        System.out.println(time() + ", " + obj);
    }

    public static void println2(String text, Object... args) {
        System.out.println(String.format(text, args));
    }

    public static void println(String text, Object... args) {
        System.out.println(String.format(time() + ", " + text, args));
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static String time() {
        return LocalTime.now().format(dtf);
    }
}