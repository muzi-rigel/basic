package com.rigel.basic.base.interfaceandabstractdemo;

public interface Animal {

//    Modifier private not allowed here
//    private int cat;

    void print();

    //jdk1.8之后 default或static修饰的可以有方法体
    default void print2() {

    }

    static void print3() {

    }
}
