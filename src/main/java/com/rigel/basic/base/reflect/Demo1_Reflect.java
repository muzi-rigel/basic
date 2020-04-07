package com.rigel.basic.base.reflect;


//* 获取字节码文件对应的Class类型的对象的三种方式
//	* a:Object类的getClass()方法,判断两个对象是否是同一个字节码文件
//	* b:静态属性class,锁对象
//	* c:Class类中静态方法forName(),读取配置文件

public class Demo1_Reflect {

    public static void main(String[] args) throws Exception {

        //	* c:Class类中静态方法forName(),读取配置文件
        Class clazz1 = Class.forName("com.rigel.basic.base.reflect.Person");
        //	* b:静态属性class,锁对象
        Class clazz2 = Person.class;
        Person p = new Person();
        //	* a:Object类的getClass()方法,判断两个对象是否是同一个字节码文件
        Class clazz3 = p.getClass();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

        Person o = (Person) clazz1.newInstance();
        o.run();
    }
}
