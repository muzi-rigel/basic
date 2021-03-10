package com.rigel.basic.base.传递.值传递;

public class Demo1 {

    public static void main(String[] args) {
        Integer I1 = new Integer(300);
        Integer I2 = I1;

        dosomething(I2);

        System.out.println(I1 == I2);
    }

    static void dosomething(Integer i) {
//        i = new Integer(400);
        i = 500;
    }
}
