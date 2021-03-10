package com.rigel.basic.base.interfaceandabstractdemo;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface Animal {

//    Modifier private not allowed here
//    private int cat;

    void print();

    String name = "lisi";

    //jdk1.8之后 default或static修饰的可以有方法体
    default void print2() {

    }

    static void print3() {

    }

    void method();

    public static void main(String[] args) throws Exception {
        System.out.println(Modifier.toString(Animal.class.getMethod("method").getModifiers()));
        //接口方法默认public abstract修饰 抽象类没有

        Constructor<?>[] constructors = Animal.class.getConstructors();
        System.out.println(constructors.length);
        //长度0 接口不能有构造方法

        Field name = Animal.class.getDeclaredField("name");
        System.out.println(Modifier.toString(name.getModifiers()));
        //接口里的变量都是public static final的


    }
}
