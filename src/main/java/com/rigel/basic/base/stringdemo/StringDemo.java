package com.rigel.basic.base.stringdemo;

public class StringDemo {

    public static void main(String[] args) {
//        用new String（）创建的字符串不是常量，不能在编译期就确定，
//        所以new String（）创建的字符串不放入常量池中，他们有自己的地址空间。
        //s1,s2分别位于栈中，指向堆中不同的空间
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);//输出false
        //s3,s4位于池中同一空间
        String s3 = "hello";
        String s4 = "hello";
        System.out.println(s3 == s4);//输出true

    }
}
