package com.rigel.basic.base.Object;

public class FinalizeDemo {
    public static void main(String[] args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        System.gc();
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
