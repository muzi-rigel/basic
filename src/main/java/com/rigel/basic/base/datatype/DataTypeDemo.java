package com.rigel.basic.base.datatype;

public class DataTypeDemo {

    public static void main(String[] args) {
//        byte b = new Byte();

        //127
        //-128
        //32767
        //-32768
        //2147483647
        //-2147483648
        //9223372036854775807
        //-9223372036854775808

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);

        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);

        System.out.println(Integer.toBinaryString(1));
        //11111111111111111111111111111111 反码
        System.out.println(Integer.toBinaryString(-1));

        float f = Float.MAX_VALUE;
        System.out.println(f);
        float f2 = 3e38f;

        double b = Double.MAX_VALUE;
        System.out.println(b);


    }
}