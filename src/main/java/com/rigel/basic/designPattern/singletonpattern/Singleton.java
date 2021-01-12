package com.rigel.basic.designPattern.singletonpattern;

public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /*
        singleton 采用 volatile 关键字修饰也是很有必要的，
        singleton = new Singleton(); 这段代码其实是分为三步执行：
        为 singleton 分配内存空间
        初始化 singleton
        将 singleton 指向分配的内存地址
        但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。
        指令重排在单线程环境下不会出现问题，
        但是在多线程环境下会导致一个线程获得还没有初始化的实例。
        例如，线程 T1 执行了 1 和 3，此时 T2 调用 getsingleton()
        后发现 singleton 不为空，因此返回 singleton，
        但此时 singleton 还未被初始化。
     */
}
