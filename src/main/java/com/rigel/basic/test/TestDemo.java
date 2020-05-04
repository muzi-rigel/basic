package com.rigel.basic.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestDemo {


    public static void main(String[] args) throws IOException {

        System.out.println(1&1);
        System.out.println(1&0);
        System.out.println(0&0);
        System.out.println(0&1);
        System.out.println("-----------");
        System.out.println(1|1);
        System.out.println(1|0);
        System.out.println(0|0);
        System.out.println(0|1);
        System.out.println("-----------");
        System.out.println(1^1);
        System.out.println(1^0);
        System.out.println(0^0);
        System.out.println(0^1);
        System.out.println("----------");


        File file = new File("C:\\Users\\Lenovo\\Desktop\\World.java");
        FileInputStream fis = new FileInputStream(file);
        byte[] bs = new byte[(int) file.length()];
        fis.read(bs);
        for (byte b : bs) {
            System.out.println(b);
        }
        fis.close();



//        1000 1101 0101
    }
}

