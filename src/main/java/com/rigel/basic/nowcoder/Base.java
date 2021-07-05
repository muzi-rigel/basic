package com.rigel.basic.nowcoder;

public class Base {
    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println("father's callName:" + baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        public void callName() {
            System.out.println("child's callName:" + baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();

        //问 输出什么
    }
}