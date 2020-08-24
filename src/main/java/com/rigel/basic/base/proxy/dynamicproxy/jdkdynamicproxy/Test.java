package com.rigel.basic.base.proxy.dynamicproxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

    public static void main(String[] args) {
        User u = new UserImpl();
        User o = (User) Proxy.newProxyInstance(u.getClass().getClassLoader(),
                u.getClass().getInterfaces(), new MyInvocationHandler(u));
        o.add();
        o.delete();

        User u1 = (User)Proxy.newProxyInstance(Test.class.getClassLoader(),
                u.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("---权限校验---");
                        Object invoke = method.invoke(u,args);
                        System.out.println("===记录日志===");

                        return proxy;
                    }
                });

        Object add = u1.add();

    }
}
