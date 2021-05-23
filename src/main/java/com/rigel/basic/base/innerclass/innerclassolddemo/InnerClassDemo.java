package com.rigel.basic.base.innerclass.innerclassolddemo;

//外部类
public class InnerClassDemo {

    // 编译上面的程序后，会发现产生了两个 .class 文件
    //
    //其中，第二个是外部类的 .class 文件，第一个是内部类的 .class 文件，即成员内部类的 .class 文件总是这样：外部类名$内部类名.class
    int b = 1;

    public static void main(String[] args) {
        InnerClassDemo demo = new InnerClassDemo();
        //创建内部类对象
        Inner i = demo.new Inner();
        //调用内部类对象的方法
        i.show();

    }

    //内部类
    public class Inner {
        int b = 2;

        //内部类方法
        public void show() {
            System.out.println("welcome to China!");
            System.out.println("b=" + b);
            System.out.println("b=" + InnerClassDemo.this.b);
        }

    }
}
