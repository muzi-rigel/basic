package com.rigel.basic.base.Reflect;


public class Person {

    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void run(){
        System.out.println("人在跑");
    }

}
