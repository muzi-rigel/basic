package com.rigel.basic.base.object;

public class FinalizeDemo {
    public static void main(String[] args) {
        Book novel = new Book(true);
//        novel.checkIn();
        new Book(true);
        novel = null;
//        System.gc();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Book {
    boolean checkout = false;

    public Book(boolean checkout) {
        this.checkout = checkout;
    }

    void checkIn() {
        checkout = false;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Error checkIn");
    }
}
