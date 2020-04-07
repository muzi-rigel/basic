package com.rigel.basic.base.proxy.staticproxy;

public class UserImpl implements User {
    @Override
    public void add() {
        System.out.println("注册用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }
}
