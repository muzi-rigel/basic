package com.rigel.basic.DesignPattern.模板模式;

/**
 *  定义一个算法的骨架 将具体的算法延迟到子类来实现
 */
public class Demo1_Template {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getTime());
    }

}

abstract class GetTime {
    public final long getTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public abstract void code();
}
class Demo extends GetTime{

    @Override
    public void code() {
        int i = 0;
        while(i < 100000){
            System.out.println("x");
            i++;
        }
    }
}