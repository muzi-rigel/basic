package com.rigel.basic.base.demo1;

public abstract class AbstractDemo2 {

    //抽象类不一定有抽象方法
    public void eat(){

    }

    //抽象方法不能有方法体
    public abstract void eat(String foodName);


}

class Demo3 extends AbstractDemo2{

    /**
     * 非抽象子类必须给出抽象类中抽象方法的具体实现
     * @param foodName
     */
    @Override
    public void eat(String foodName) {

    }
}

