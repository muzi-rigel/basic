package com.rigel.basic.base.传递.引用传递;

class Demo1 {

    public static void main(String[] args) throws Exception {

        User u = new User("xiaoming");
        fun(u);
        System.out.println(u.getName());
    }

    static void fun(User user){
//        user = new User("lisi");
        //结果为xiaoming 方法局部变量引向新对象

        user.setName("lisi");
        //结果为lisi 方法局部变量和方法外对象指向一片内存空间

        //集合和Maps一样
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
