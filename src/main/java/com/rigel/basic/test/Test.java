package com.rigel.basic.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

class Test implements F {

    public static void main(String[] args) throws Exception {
        args = new String[]{"1","2","3"};
        System.out.println(args[0]);
        int i = 5;
        int j = 10;
        System.out.println(~i);

        System.out.println(args[0]);
        for(String a : args){
            System.out.println(a);
        }
        System.out.println("-----");
        List list = Arrays.asList(args);
        System.out.println(list);
        System.out.println("-----");
        Arrays.asList(args).forEach(System.out::println);


        int a = 1;
        int b = (short) a * 3;


        System.out.println(Modifier.toString(F.class.getMethod("method").getModifiers()));
        System.out.println("-----");

        Constructor<?>[] constructors = F.class.getConstructors();
        System.out.println(constructors.length);
        //长度0 接口不能有构造方法

        Field name = F.class.getDeclaredField("name");
        System.out.println(Modifier.toString(name.getModifiers()));
        //接口里的变量都是public static final的

        System.out.println("---------");
        Method talk = D.class.getDeclaredMethod("talk");
        System.out.println(Modifier.toString(talk.getModifiers()));
    }

    public c method(){

        return null;
    }
}

interface F {
    String name = "lisi ";
    int a = 1;
    b method();

}

class a {

}

class b extends a {

}

class c extends b {

}
abstract class D{
    String name = "aaa";
    void talk(){

    }
}