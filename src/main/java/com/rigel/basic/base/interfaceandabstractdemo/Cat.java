package com.rigel.basic.base.interfaceandabstractdemo;

public abstract class Cat {

    protected void eat() {
        System.out.println("I am a cat,i like eat!");
    }

    abstract void drink();
}

class BlackCat extends Cat {

//    不正确 访问级别需大于等于抽象类
//    private void eat(){}

    public void eat(){
        System.out.println("I am a black cat,i like eat too!");
    }

    @Override
    void drink() {

    }


}

