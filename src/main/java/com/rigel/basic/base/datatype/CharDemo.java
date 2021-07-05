package com.rigel.basic.base.datatype;

public class CharDemo {

    int i;

    public static void main(String[] args) {

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i;
//        System.out.println(i);
        System.out.println("--------------");
        System.out.println(new CharDemo().i);

//        char到底占了多少字节？
//        由于英文字母比较特殊，源自于8位（1字节）的ASCII码。于是在unicode中使用低8位（1字节）就可以表示，高8位不使用也无所谓；--------存储到内存中就只使用了1字节
//        但汉字就使用了完整的16位unicode；--------存储到内存中就使用了2字节
        String s1 = "a";
        System.out.println(s1.getBytes().length);
//        ---------1

        s1 = "1";
        System.out.println(s1.getBytes().length);
//        ---------1

        s1 = ",";
        System.out.println(s1.getBytes().length);
//        ---------1

        s1 = "abc";
        System.out.println(s1.getBytes().length);
//        ---------3

        s1 = "我";
        System.out.println(s1.getBytes().length);
//        ---------2

        s1 = "我爱你";
        System.out.println(s1.getBytes().length);
//        ---------6
        s1 = "我爱你abc";
        System.out.println(s1.getBytes().length);
//        ---------6+3
//        String 就是char[]的封装类型
    }

}
