package com.rigel.basic.base.polymorphic.mulandemo;

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
        try {
            huaHu.getClass().getMethod("beauty").invoke(huaHu);
            System.out.println("----以下语句会输出HuaMuLan----");
            System.out.println(huaHu.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        HuaMuLan mulan = (HuaMuLan) huaHu;
        mulan.beauty();

    }
}
