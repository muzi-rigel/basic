package com.rigel.basic.base.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        User u = new UserImpl();
        User o = (User) Proxy.newProxyInstance(u.getClass().getClassLoader(),
                u.getClass().getInterfaces(), new MyInvocationHandler(u));
        o.add();
        o.delete();
    }
}