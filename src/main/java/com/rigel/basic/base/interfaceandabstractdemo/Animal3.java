package com.rigel.basic.base.interfaceandabstractdemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public interface Animal3 extends Animal, Animal2 {

    //java类是单继承的。classB Extends classA
    //java接口可以多继承。Interface3 Extends Interface0, Interface1, interface……
    //
    //        不允许类多重继承的主要原因是，如果A同时继承B和C，而b和c同时有一个D方法，A如何决定该继承那一个呢？
    //        但接口不存在这样的问题，接口全都是抽象方法继承谁都无所谓，所以接口可以继承多个接口。

    int a = 10; //默认public static final

    void eat();

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Field a = Animal3.class.getDeclaredField("a");
        System.out.println(Modifier.toString(a.getModifiers()));
        //接口成员变量默认 public static final

        Method eat = Animal3.class.getMethod("eat");
        System.out.println(Modifier.toString(eat.getModifiers()));
        //public abstract接口方法默认 public abstract 不能是private 说是JDK1.9可以
        //1.8可以是default 但是default得有方法体

    }
}
