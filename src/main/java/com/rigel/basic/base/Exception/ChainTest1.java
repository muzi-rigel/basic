package com.rigel.basic.base.Exception;

public class ChainTest1 {

    public static void main(String[] args) {
        ChainTest1 ct = new ChainTest1();
        ct.test2();
    }

    public void test2(){
        try {
            test1();
        } catch (DrunkException e) {
            RuntimeException newExc = new RuntimeException("司机一滴酒，亲人两行泪！");
            newExc.initCause(e);
            throw newExc;
        }
    }

    public void test1() throws DrunkException{
        throw new DrunkException("喝酒别开车！");
    }
}
