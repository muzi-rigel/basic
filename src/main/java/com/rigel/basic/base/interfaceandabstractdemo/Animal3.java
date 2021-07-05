package com.rigel.basic.base.interfaceandabstractdemo;

public interface Animal3 extends Animal, Animal2 {

    //java类是单继承的。classB Extends classA
    //java接口可以多继承。Interface3 Extends Interface0, Interface1, interface……
    //
    //        不允许类多重继承的主要原因是，如果A同时继承B和C，而b和c同时有一个D方法，A如何决定该继承那一个呢？
    //        但接口不存在这样的问题，接口全都是抽象方法继承谁都无所谓，所以接口可以继承多个接口。
}
