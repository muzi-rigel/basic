package com.rigel.basic.base.innerclass.demo.localinnerclass.anonymousinnerclass;

public class Outer {

    public void method() {
//        new Inter(){
//            @Override
//            public void show() {
//                System.out.println("Anonymous inner class");
//            }
//        }.show();

        Inter inner = new Inter() {
            @Override
            public void show() {
                int age = 10;
                System.out.println("Anonymous inner class" + age);
            }
        };
        inner.show();

        Inter inner2 = () -> System.out.println("Anonymous inner class");
        inner.show();

        Inter inner3 = () -> {
            int age = 10;
            System.out.println("Anonymous inner class" + age);
        };

        Inter inner4 = ()-> System.out.println("sss");
    }

}
