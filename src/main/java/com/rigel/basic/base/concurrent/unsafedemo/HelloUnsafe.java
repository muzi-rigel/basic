package com.rigel.basic.base.concurrent.unsafedemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * unsafe 可以获得私有构造方法的类
 */
public class HelloUnsafe {

    public static void main(String[] args) throws InstantiationException, NoSuchFieldException, IllegalAccessException {
//        Unsafe unsafe = Unsafe.getUnsafe();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        M m = (M) unsafe.allocateInstance(M.class);
        System.out.println(m.i);
        m.eat();

    }
}

class M {
    private M() {

    }

    int i = 9;

    void eat() {
        System.out.println("hahah");
    }
}
