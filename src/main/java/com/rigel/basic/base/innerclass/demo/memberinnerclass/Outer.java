package com.rigel.basic.base.innerclass.demo.memberinnerclass;

/**
 * 成员内部类
 */
public class Outer {

    //内部类可以直接访问外部类的成员 包括私有 但静态内部类不能访问非静态资源
    //外部类要访问内部类的成员 必须创建对象

    private int age = 10;

    private class Inner {
        private int size = 36;
        public void show() {
            System.out.println(age);
        }
    }

    public void method(){
//        show();
        Inner inner = new Inner();
        inner.show();
        System.out.println(inner.size);
    }


}
