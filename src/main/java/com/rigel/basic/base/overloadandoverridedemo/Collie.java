package com.rigel.basic.base.overloadandoverridedemo;

import java.io.FileNotFoundException;

public class Collie extends Dog{


    @Override
    public int getAge(int a,String b) {
        System.out.println("Collie's getAge");
        return 0;
    }

    //子类返回类型应小于父类
    @Override
    public Beef getFood() throws FileNotFoundException {
        System.out.println("Collie's getFood");
        return null;
    }

    public void A(){
        System.out.println("Collie's A");
        B();
    }

    public void B(){
        System.out.println("Collie's B");
    }


    public static void main(String[] args) throws FileNotFoundException {

        Dog a = new Dog();
        a.A();


    }
}
