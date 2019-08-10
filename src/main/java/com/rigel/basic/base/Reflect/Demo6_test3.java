package com.rigel.basic.base.Reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  普通练习 注意 xxx.properties的位置
 */
public class Demo6_test3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        BufferedReader reader = new BufferedReader(new FileReader("xxx.properties"));
        Class clazz = Class.forName(reader.readLine());

        DemoClass demoClass = (DemoClass) clazz.newInstance();
        demoClass.run();

    }
}

class DemoClass {
    public void run() {
        System.out.println("welcome to heima!");
    }
}