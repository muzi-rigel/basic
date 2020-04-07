package com.rigel.basic.base.innerclass;

//静态内部类
//外部类
public class StaticInnerClassDemo {

    int a = 0;
    static int b = 1;

    public static void main(String[] args) {
        //创建内部类对象
        Inner i = new Inner();
        //调用内部类对象的方法
        i.show();

    }

    //内部类
    public static class Inner {
        int b = 2;

        //内部类方法
        public void show() {
            System.out.println("welcome to China!");
            System.out.println("b=" + b);
            System.out.println("b=" + StaticInnerClassDemo.b);
        }

    }
}
