package com.rigel.basic.base.动态代理;

public class UserImpl implements User{
    @Override
    public void add() {
        System.out.println("注册用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }
}
