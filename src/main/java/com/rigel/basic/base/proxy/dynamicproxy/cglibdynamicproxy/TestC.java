package com.rigel.basic.base.proxy.dynamicproxy.cglibdynamicproxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestC {

    @Test
    public void test1(){
        UserImpl user = new UserImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                System.out.println("权限校验");
                method.invoke(user, objects);
                System.out.println("记录日志");

                return null;
            }
        });
        UserImpl o = (UserImpl) enhancer.create();
        o.add();
        o.delete();
    }

}
