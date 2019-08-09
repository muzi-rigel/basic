package com.rigel.basic.base.Reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

//怎么往 ArrayList<Integer>集合中添加一个字符串数据，如何实现?
//泛型只是在编译器有效，运行期会擦除
public class Demo5 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);

        Class clazz = Class.forName("java.util.ArrayList");

        Method m = clazz.getMethod("add", Object.class);

        m.invoke(list,"abc");

        System.out.println(list);


    }
}
