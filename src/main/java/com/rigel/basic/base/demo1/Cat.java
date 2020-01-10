package com.rigel.basic.base.demo1;

public class Cat extends Animal {

    public static void main(String[] args) throws InterruptedException {

        Animal animal = new Cat();
        Class<? extends Animal> aClass = animal.getClass();
        System.out.println(aClass.getName());
        System.out.println(Animal.class.getName());
//        try {
//            cat.finalize();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
        Thread.sleep(3000);
    }
}
