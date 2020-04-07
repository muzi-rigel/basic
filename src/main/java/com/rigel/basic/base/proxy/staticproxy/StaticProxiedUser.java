package com.rigel.basic.base.proxy.staticproxy;

public class StaticProxiedUser implements User{

    private User user = new UserImpl();

    @Override
    public void add() {
        System.out.println("---权限校验---");
        user.add();
        System.out.println("===记录日志===");
    }

    @Override
    public void delete() {
        System.out.println("---权限校验---");
        user.delete();
        System.out.println("===记录日志===");
    }
}
