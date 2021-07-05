package com.rigel.basic.test;

public class Test2 {

    public int x;

    public static void main(String[] args) {

        String result = new String();
        int a = 3;
        switch (a){
            case 2:
                result += "him";
            case 1:
                result += "her";
            case 3:
                result += "it";
            default:
                result += "me";
        }
        System.out.println(result);
//        System.out.println(test());

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

