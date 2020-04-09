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
        System.out.println("f=" + f);
        float f2 = Float.MIN_VALUE;
        System.out.println("f2=" + f2);
        float f3 = 3e38f;
        System.out.println("------------");

        double b = Double.MAX_VALUE;
        System.out.println(b);
        double b2 = Double.MIN_VALUE;
        System.out.println(b2);

        char c = '中';
        System.out.println((int) c);

        System.out.println("----------");

        /*
            boolean的长度为4字节（编译之后当成int hotspot中 可能依赖于虚拟机实现）
            boolean数组长度为1
        */

        Boolean br[] = new Boolean[]{true, false};

        Integer i  = 6;
        Integer j = 6;
        Integer k = new Integer(6);

//      true
        System.out.println(i==j);
//      false
        System.out.println(i==k);
//      false
        System.out.println(j==k);

        Integer i1  = 222;
        Integer j1 = 222;
        Integer k1 = new Integer(222);

//      false
        System.out.println(i1==j1);
//      false
        System.out.println(i1==k1);
//      false
        System.out.println(j1==k1);
    }
}