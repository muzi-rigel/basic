package com.rigel.basic.test;

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