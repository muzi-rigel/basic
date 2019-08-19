package com.rigel.basic.test;

import java.util.Arrays;

public class TestDemo {


    public static void main(String[] args) {

        A a = new A();
        A b = new A();

        System.out.println(a.elementData == b.elementData);


//        a.elementData = new Object[]{1,3,5,6};
        A.DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[]{1,3,5,6};
        System.out.println(Arrays.toString(a.elementData));
        System.out.println(Arrays.toString(b.elementData));
        System.out.println(a.elementData == b.elementData);
    }
}


class A {

    static Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {1,3};
    Object[] elementData;

    public A() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
}
