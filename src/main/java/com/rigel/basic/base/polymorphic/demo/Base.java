package com.rigel.basic.base.polymorphic.demo;

public class Base {
    public void methodOne()
    {
        System.out.print("A");
        methodTwo();
    }

    public void methodTwo()
    {
        System.out.print("B");
    }
}

