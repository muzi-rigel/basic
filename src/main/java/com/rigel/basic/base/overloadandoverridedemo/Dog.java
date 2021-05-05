package com.rigel.basic.base.overloadandoverridedemo;

import java.io.FileNotFoundException;

public class Dog implements Animal{


    @Override
    public int getAge(int a,String b) {
        System.out.println("Dog's getAge");
        return 0;
    }

    //子类返回类型应小于父类
    @Override
    public Beef getFood() throws FileNotFoundException {
        System.out.println("Dog's getFood");
        return null;
    }

    public void A(){
        System.out.println("Dog's A");
        this.B();
    }

    public void B(){
        System.out.println("Dog's B");
    }

    //重载overload 返回类型可以不一样
    public void say(){

    }
    public int say(String world){

        return 0;
    }

    //参数顺序
    public int say(int a,String world){

        return 0;
    }
    public int say(String world,int a){

        return 0;
    }
}
