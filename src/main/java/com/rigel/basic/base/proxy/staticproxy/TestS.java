package com.rigel.basic.base.proxy.staticproxy;


import org.junit.Test;

public class TestS {


    @Test
    public void test1(){
        StaticProxiedUser user = new StaticProxiedUser();
        user.add();
        user.delete();
    }


}
