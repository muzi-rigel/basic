package com.rigel.basic.base.reflect;


public class Person {

    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void run() {
        System.out.println("人在跑");
    }

    public void eat() {
        System.out.println("今天吃了一顿金钱豹");
    }

    public void eat(int num) {
        System.out.println("今天吃了" + num + "顿金钱豹");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
