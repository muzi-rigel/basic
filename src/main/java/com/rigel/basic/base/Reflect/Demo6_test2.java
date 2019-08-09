package com.rigel.basic.base.Reflect;

import java.lang.reflect.Field;

public class Demo6_test2 {

    /**
     通过反射写一个通用的设置某个对象的某个属性为指定的值)
     * A:案例演示
     * public void setProperty(Object obj, String propertyName, Object value){}，此方法可将obj对象中名为propertyName的属性的值设置为value。
     */

    public static void main(String[] args) throws Exception {
        Person p = new Person("wangwu", 22);
        System.out.println(p);
        Tool.setProperty(p,"name","heihei");
        System.out.println(p);

    }
}

class Tool {
    public static void setProperty(Object obj, String propertyName, Object value) throws Exception {
        Class clazz = obj.getClass();
        Field f = clazz.getDeclaredField(propertyName);
        f.setAccessible(true);

        f.set(obj, value);
    }
}
