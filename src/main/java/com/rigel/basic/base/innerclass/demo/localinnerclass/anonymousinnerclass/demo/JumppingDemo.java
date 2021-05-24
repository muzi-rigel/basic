package com.rigel.basic.base.innerclass.demo.localinnerclass.anonymousinnerclass.demo;

public class JumppingDemo {

    public static void main(String[] args) {
        JumppingOperator jo = new JumppingOperator();
        jo.method(new Jumpping() {
            @Override
            public void jump() {
                System.out.println("猫可以跳高了！！");
            }
        });

        jo.method(()-> System.out.println("狗可以跳高了！"));
    }

}
