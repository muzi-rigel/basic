package com.rigel.basic.base.polymorphic.mulandemo;

//花木兰爸爸
public class HuaHu {
    public String name = "huahu";
    public Integer age = 60;

    public void fight(){
        System.out.println(this.name + "在战斗");
    }

    public static void introduce(){
        System.out.println("我叫huahu，我今年60");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
