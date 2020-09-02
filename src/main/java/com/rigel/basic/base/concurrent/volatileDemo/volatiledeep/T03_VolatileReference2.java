package com.rigel.basic.base.concurrent.volatileDemo.volatiledeep;

public class T03_VolatileReference2 {


    static Data data;

    public static void main(String[] args) {

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                data = new Data(i, i);
            }
        });

        Thread reader = new Thread(() -> {
            while (data == null) {
            }
            int x = data.a;
            int y = data.b;
            System.out.printf("a = %s, b=%s%n", x, y);
            if (x != y) {
                System.out.printf("a = %s, b=%s%n", x, y);
            }
        });

        reader.start();
        writer.start();

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }

}

class Data {
    int a, b;

    public Data(int a, int b) {
        this.a = a;
        this.b = b;
    }

}
