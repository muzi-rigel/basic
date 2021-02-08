package com.rigel.basic.base.polymorphic.demo;

public class Demo {
    public static void main(String[] args) {
        Base b = new Derived();
        b.methodOne();
        //ABDC
//        只要是被子类重写的方法，不被super调用都是调用子类方法
    }
}
