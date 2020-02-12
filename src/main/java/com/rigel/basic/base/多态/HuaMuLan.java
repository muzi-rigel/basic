package com.rigel.basic.base.多态;

public class HuaMuLan extends HuaHu{

    public String name = "huamulan";
    public Integer age = 28;

    public void fight(){
        System.out.println(this.name + "在战斗");
    }

    public static void introduce(){
        System.out.println("我叫huamulan，我今年28");
    }

    public void beauty(){
        System.out.println("涂抹胭脂");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }
}
