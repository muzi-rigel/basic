package com.rigel.basic.base.demo1;

public class StaticBlockDemo {

    static int num2;

    static {//静态初始化块  1 一次
//        静态初始化块只在类加载时执行，且只会执行一次，同时静态初始化块只能给静态变量赋值，不能初始化普通的成员变量。
        num2 = 1;
//        num1 = 3;
        System.out.println("执行静态初始化块。。。");
    }

    int num1;

    {//初始化块 2 两次
        num2 = 2;
        num1 = 2;
        System.out.println("执行初始化块。。。");
    }

    public StaticBlockDemo() {//构造方法  3 两次
        num2 = 3;
        num1 = 1;
        System.out.println("执行构造方法。。。");
    }

    public static void main(String[] args) {
        StaticBlockDemo demo = new StaticBlockDemo();
        System.out.println("num1:" + demo.num1);
        System.out.println("num2:" + num2);
        StaticBlockDemo demo2 = new StaticBlockDemo();
        StaticBlockDemo demo3 = new StaticBlockDemo();

//        结果：
//        执行静态初始化块。。。
//        执行初始化块。。。
//        执行构造方法。。。
//        num1:1
//        num2:3
//        执行初始化块。。。
//        执行构造方法。。。
//        执行初始化块。。。
//        执行构造方法。。。
    }
}
