package com.rigel.basic.base.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test {

    /**
     *  测试getXXX和getDeclaredxxx
     */
    public static void main(String[] args) {

        Field[] fields = Cat.class.getFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("--------------------");

        Field[] f2 = Cat.class.getDeclaredFields();
        System.out.println(f2.length);
        for (Field field : f2) {
            System.out.println(field);
        }

        System.out.println("--------------------");


        Method[] methods = Cat.class.getMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("--------------------");
        Method[] m2 = Cat.class.getDeclaredMethods();
        System.out.println(m2.length);
        for (Method method : m2) {
            System.out.println(method);
        }

    }
}
