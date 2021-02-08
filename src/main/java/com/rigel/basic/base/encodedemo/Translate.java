package com.rigel.basic.base.encodedemo;


import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Translate {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "你好中国！";
        System.out.println(Arrays.toString(str.getBytes("utf-8")));

        String str2 = new String(str.getBytes("utf-8"), "ISO-8859-1");
        System.out.println(str2);

        String str3 = new String(str2.getBytes("ISO-8859-1"), "GBK");
        System.out.println(str3);


        String str4 = new String(new String(str3.getBytes("GBK"), "ISO-8859-1").getBytes("ISO-8859-1"), "utf-8");
        System.out.println(new String(str4.getBytes("utf-8")));


    }
}
