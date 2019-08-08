package com.rigel.basic.base.Reflect;


//* 获取字节码文件对应的Class类型的对象的三种方式
//	* a:Object类的getClass()方法,判断两个对象是否是同一个字节码文件
//	* b:静态属性class,锁对象
//	* c:Class类中静态方法forName(),读取配置文件

import java.lang.reflect.Constructor;

public class Demo2 {

    public static void main(String[] args) throws Exception {

        Class clazz1 = Class.forName("com.rigel.basic.base.Reflect.Person");
        Constructor constructor = clazz1.getConstructor();
        Person person = (Person) constructor.newInstance();
        person.run();

        Constructor constructor1 = clazz1.getConstructor(String.class, int.class);
        Person p2 = (Person) constructor1.newInstance("zhangsan",21);
        p2.run();

    }
}
