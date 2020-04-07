package com.rigel.basic.base.proxy.dynamicproxy.cglibdynamicproxy;

import com.rigel.basic.base.proxy.staticproxy.User;

public class UserImpl implements User {

    public void add() {
        System.out.println("注册用户");
    }

    public void delete() {
        System.out.println("删除用户");
    }
}
