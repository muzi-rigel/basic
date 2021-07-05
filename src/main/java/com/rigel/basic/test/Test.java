package com.rigel.basic.test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test {
    int x;

    public static void main(String[] args) {
        Test test = new Test();
        test.x = 1;
        System.out.println(test.x);
    }
}