package com.rigel.basic.base.interfaceandabstractdemo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Animal4 {

    int a;

    public static void main(String[] args) throws NoSuchFieldException {
        Field a = Animal4.class.getDeclaredField("a");
        System.out.println(Modifier.toString(a.getModifiers()));
        //空 没有修饰符 抽象类可以定义普通成员变量而接口不可以 接口默认 public static final
    }
}
