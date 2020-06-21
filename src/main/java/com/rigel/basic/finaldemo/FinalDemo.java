package com.rigel.basic.finaldemo;

public class FinalDemo {

    final int age;

    public FinalDemo(int age) {
        this.age = age;
    }

//    public void setAge(int age){
//        this.age = age;
//    }

    public void flight(final String str){
//        str = "a";
        System.out.println(str);
    }
}
