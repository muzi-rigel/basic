package com.rigel.basic.base.多态;

public class World {

    public static void main(String[] args) {


        /**
         * 只有非静态的成员方法,编译看左边,运行看右边
         */
        HuaHu huaHu = new HuaMuLan();
        huaHu.fight();
        System.out.println(huaHu.age);
        System.out.println(huaHu.getAge());
        HuaHu.introduce();
        HuaMuLan.introduce();
        HuaMuLan mulan = (HuaMuLan) huaHu;
        mulan.beauty();

    }
}
