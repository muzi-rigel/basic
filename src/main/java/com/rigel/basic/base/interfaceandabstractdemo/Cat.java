package com.rigel.basic.base.interfaceandabstractdemo;

public abstract class Cat {

    public Cat(){
        System.out.println("抽象类可以有构造方法！ 只是不能实例化！ 子类会调用父类的构造方法");
    }

    private String name = "cat";

    protected void eat() {
        System.out.println("I am a cat,i like eat!");
    }

    abstract void drink();

    public String getName(){
        return name;
    }
}

class BlackCat extends Cat {


    private String name = "black cat";

//    不正确 访问级别需大于等于抽象类
//    private void eat(){}

    public void eat(){
        System.out.println("I am a black cat,i like eat too!");
    }

    @Override
    void drink() {

    }


}

