package com.rigel.basic.base.interfaceandabstractdemo;

public class Example {

    public static void main(String[] args) {
        BlackCat cat = new BlackCat();
        cat.eat();

        Cat cat1 = new BlackCat();
        cat1.eat();

        System.out.println(cat.getName());


    }
}
