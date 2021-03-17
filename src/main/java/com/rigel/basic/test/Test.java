package com.rigel.basic.test;

import java.lang.reflect.Field;
import java.util.Arrays;

class Test implements F {

    public static void main(String[] args) throws Exception {

        User u = new User("xiaoming");
        fun(u);
        System.out.println(u.getName());
    }

    static void fun(User user){
//        user = new User("lisi");
        user.setName("lisi");
    }

}

interface F {

}
interface G extends H,I {

}
interface H{

}
interface I{

}
class J{
    public String name = "Person";
    int age = 0;
}
class K extends J{
    public  String grade;
    private int size;

    public static void main(String[] args) {
        J j = new K();
        System.out.println(j.name);
        Field[] fields = j.getClass().getDeclaredFields();
        Field[] fields2 = j.getClass().getFields();
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(fields2));
    }
}
class User{
    private String name;

    public User(String xiaoming) {
        this.name = xiaoming;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}