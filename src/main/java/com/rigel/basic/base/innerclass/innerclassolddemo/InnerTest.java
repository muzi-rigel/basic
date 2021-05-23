package com.rigel.basic.base.innerclass.innerclassolddemo;

public class InnerTest {

    int a = 0;
    static int b = 0;
    private String s;
    private static String j;

    class Inner1{
        void Test(){
            System.out.println(a);//外围类属性
            System.out.println(b);//外围类静态属性
            System.out.println(s);//外围类私有属性
            System.out.println(j);//外围类静态私有属性
            /**
             * 总结：
             * 非静态内部类
             * 1、可以访问外围类的非静态数据，包括私有数据
             * 2、可以方位外围类的静态数据，包括静态私有数据
             */
        }
    }

    static class Inner2{
        void test(){
//            System.out.println(a);//外围类属性
            System.out.println(b);//外围类静态属性
//            System.out.println(s);//外围类私有属性
            System.out.println(j);//外围类静态私有属性
            /**总结
                静态内部类
                1、可以访问外围类的静态数据，包括静态私有数据
                2、不能访问外围类的非静态数据
             */
        }
    }


}
