package com.rigel.basic.base.proxy.dynamicproxy.jdkdynamicproxy;

public class UserImpl implements User{
    @Override
    public Object add() {
        System.out.println("注册用户");
        return 1;
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }
}
