package com.rigel.basic.base.datatype;

/**
 * 该DEMO用于展示引用传递 对引用的修改会不会影响原对象 -->  内部修改才会
 */
public class IntegerDemo1 {
    public static void change1(SimInt si){
        si=new SimInt(3);//重新指向了新的对象，原对象不受影响
    }
    public static void change2(SimInt si){
        si.value=3;//通过引用操作对象内部成员，原对象被改变
    }
    public static void main(String args[]) {
        SimInt si1=new SimInt(1);
        System.out.println(si1.value);//输出1
        change1(si1);
        System.out.println(si1.value);//输出1
        change2(si1);
        System.out.println(si1.value);//输出3
    }

}
class SimInt{
    int value;
    public SimInt(int value){
        this.value=value;
    }
}