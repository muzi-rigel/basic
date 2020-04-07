package com.rigel.basic.base.exception;

public class ChainTest2 {

    public static void main(String[] args) {
        ChainTest2 ct = new ChainTest2();
        ct.test2();
    }

    public void test2(){
        try {
            test1();
        } catch (DrunkException e) {
            RuntimeException newExc = new RuntimeException(e);
            throw newExc;
        }
    }

    public void test1() throws DrunkException{
        throw new DrunkException("喝酒别开车！");
    }
}
