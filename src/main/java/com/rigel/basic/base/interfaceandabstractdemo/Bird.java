package com.rigel.basic.base.interfaceandabstractdemo;

public class Bird implements Animal3{

    @Override
    public void print() {
    }

    @Override
    public void method() {
    }

    @Override
    public void eat() {
    }

    public static void main(String[] args) {
        Bird b = new Bird();
        int i = b.a;
        System.out.println(i);
    }
}
