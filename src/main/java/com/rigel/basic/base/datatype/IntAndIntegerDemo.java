package com.rigel.basic.base.datatype;

/*
    int和integer比较大小
 */
public class IntAndIntegerDemo {
    public static void main(String[] args) {

        int a = 257;
        Integer b = 257;
        Integer c = 257;
        Integer b2 = 57;
        Integer c2 = 57;
        System.out.println(a == b);     //true
        //System.out.println(a.equals(b));  编译出错，基本型不能调用equals()
        System.out.println(b.equals(257.0)); //false
        System.out.println(b == c);      //false
        System.out.println(b2 == c2);     //true


    }
}
