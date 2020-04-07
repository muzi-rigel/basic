package com.rigel.basic.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo3_Field {

    public static void main(String[] args) throws Exception {
        Class clazz1 = Class.forName("com.rigel.basic.base.reflect.Person");

        Constructor constructor1 = clazz1.getConstructor(String.class, int.class);
        Person p2 = (Person) constructor1.newInstance("zhangsan", 21);
        p2.run();

//        Field name = clazz1.getField("name");
//        exception in thread "main" java.lang.NoSuchFieldException: name


//        Field field = clazz1.getDeclaredField("age");
//        int age = (int) field.get(p2);
//        IllegalAccessException: Class com.rigel.basic.base.reflect.Demo3_Field can not access a member of class com.rigel.basic.base.reflect.Person with modifiers "private"
//        at sun.reflect.Reflection.ensureMemberAccess(Reflection.java:102)

        Field field = clazz1.getDeclaredField("age"); //暴力反射获取字段
        field.setAccessible(true);                          //去除私有权限
        int age = (int) field.get(p2);
        System.out.println(age);

        field.set(p2, 84);
        System.out.println(p2);

    }
}
