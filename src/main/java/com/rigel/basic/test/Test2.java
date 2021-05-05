package com.rigel.basic.test;

public class Test2 {

    public int x;

    public static void main(String[] args) {

        System.out.println(test());

    }

    private static int test() {
        try {
            int a = 1 + 2;
            System.out.println("aaa");
            System.out.println("eee");
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            System.out.println("hahaha");
            return 1;
//          finally块中的return语句会覆盖try中的return
        }
    }
}

