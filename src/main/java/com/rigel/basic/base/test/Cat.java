package com.rigel.basic.base.test;

public class Cat extends Animal{

    private String color;
    String name;
    public String publicStr;
    protected String protectedStr;


    @Override
    void eat() {
        System.out.println("猫吃小鱼干");
    }
}
