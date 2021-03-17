package com.rigel.basic.base.jvm.Bytecode;

public class IntegerPush {
    public static void main(String[] args) {
        /**
         * 先了解下java里的常见整形长度表示范围：
         *
         * byte的取值范围为-128~127，占用1个字节（-2的7次方到2的7次方-1）
         *
         * short的取值范围为-32768~32767，占用2个字节（-2的15次方到2的15次方-1）
         *
         * int的取值范围为（-2147483648~2147483647），占用4个字节（-2的31次方到2的31次方-1）
         *
         * long的取值范围为（-9223372036854774808~9223372036854774807），占用8个字节（-2的63次方到2的63次方-1）
         *
         * 前言
         *
         * 当int取值-1~5采用iconst指令，取值-128~127采用bipush指令，取值-32768~32767采用sipush指令，取值-2147483648~2147483647采用 ldc 指令。
         * iconst
         *
         * 当int取值-1~5时，JVM采用iconst指令将常量压入栈中。
         * 定义Test.java文件
         *
         * 1 public static void main(String[] args) {
         * 2     int i = 5;
         * 3     int j = -1;
         * 4 }
         *
         *
         * 查看class文件
         * 复制代码
         *
         * 1 public static void main(;
         * 2 Code:
         * 3 0: iconst_5
         * 4 1: istore_1
         * 5 2: iconst_m1
         * 6 3: istore_2
         * 7 4: return
         * 8 }
         * 复制代码
         *
         *
         * 分析class文件，int取值0~5时JVM采用iconst_0、iconst_1、iconst_2、iconst_3、iconst_4、iconst_5指令将常量压入栈中，取值-1时采用iconst_m1指令将常量压入栈中。
         * bipush
         *
         * 当int取值-128~127时，JVM采用bipush指令将常量压入栈中。
         * 定义Test.java文件
         *
         * 1 public static void main(String[] args) {
         * 2     int i = 127;
         * 3 }
         *
         *
         * 查看class文件
         *
         * 1 public static void main(;
         * 2 Code:
         * 3 0: bipush 127
         * 4 2: istore_1
         * 5 3: return
         * 6 }
         *
         *
         * 可以看到上面代码第三行是采用bipush指令将常量127压入栈中。
         * sipush
         *
         * 当int取值-32768~32767时，JVM采用sipush指令将常量压入栈中。
         * 定义Test.java文件
         *
         * 1 public static void main(String[] args) {
         * 2     int i = 32767;
         * 3 }
         *
         *
         * 查看class文件
         *
         * 1 public static void main(;
         * 2 Code:
         * 3 0: sipush 32767
         * 4 3: istore_1
         * 5 4: return
         * 6 }
         *
         *
         * 可以看到上面代码第三行是采用sipush指令将常量32767压入栈中。
         * ldc
         *
         * 当int取值-2147483648~2147483647时，JVM采用ldc指令将常量压入栈中。
         * 定义Test.java文件
         *
         * 1 public static void main(String[] args) {
         * 2     int i = Integer.MAX_VALUE;
         * 3 }
         *
         *
         * 查看class文件
         *
         * 1 public static void main(;
         * 2 Code:
         * 3 0: ldc #2; //int 2147483647
         * 4 2: istore_1
         * 5 3: return
         * 6 }
         *
         *
         * 可以看到上面代码第三行是采用ldc指令将2147483647常量压入栈中，需要注意的是ldc指令是从常量池中获取值的，也就是说在这段范围（-2147483648~2147483647）内的int值是存储在常量池中的。
         * 如理解有误还望明白人不吝指出。
         */
    }
}
