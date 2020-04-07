package com.rigel.basic.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo4_Method {

    public static void main(String[] args) throws Exception {
        Class clazz1 = Class.forName("com.rigel.basic.base.reflect.Person");

        Constructor constructor1 = clazz1.getConstructor(String.class, int.class);
        Person p2 = (Person) constructor1.newInstance("zhangsan", 21);

        Method method = clazz1.getMethod("eat");  //获取eat方法
        method.invoke(p2);

        Method method2 = clazz1.getMethod("eat", int.class);
        method2.invoke(p2, 10);

    }
}
