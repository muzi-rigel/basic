package com.rigel.basic.base.innerclass.demo.localinnerclass;

/**
 * 局部内部类 local inner class
 */
public class Outer {

    public void method(){
        int age =1;
        class Inner{
            private void print(){
                System.out.println("Yes!");
                System.out.println(age);
            }
        }
        Inner inner = new Inner();
        inner.print();
    }

}
