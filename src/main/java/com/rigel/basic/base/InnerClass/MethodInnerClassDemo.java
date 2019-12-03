package com.rigel.basic.base.InnerClass;

//方法内部类
//外部类
public class MethodInnerClassDemo {

    static int b = 1;
    int a = 0;

    public static void main(String[] args) {
        MethodInnerClassDemo demo = new MethodInnerClassDemo();
        demo.show();

    }

    public void show() {
        final int a = 25;
        int b = 13;

//        由于方法内部类不能在外部类的方法以外的地方使用，因此方法内部类不能使用访问控制符和 static 修饰符。
//        static int d = 13;
//        private int e = 13;
//        public int f = 13;

        class MInner {
            int c = 2;

            public void print() {
                System.out.println("访问外部类的方法中的常量a:" + a);
                System.out.println("访问内部类中的变量c:" + c);
//                System.out.println(b);
            }
        }
        MInner mi = new MInner();
        mi.print();
    }
}
