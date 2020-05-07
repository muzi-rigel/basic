package com.rigel.basic.base.comparabledemo;

import java.util.PriorityQueue;

public class Sample {

    public static void main(String[] args) {

        PriorityQueue<Person> queue = new PriorityQueue<>();
        queue.add(new Person(1,"1"));
        System.out.println(queue);
        queue.add(new Person(2,"2"));
        System.out.println(queue);
        queue.add(new Person(3,"3"));
        System.out.println(queue);
        queue.add(new Person(4,"4"));
        System.out.println(queue);
        queue.add(new Person(5,"5"));
        System.out.println(queue);

        System.out.println("---------------------");

        PriorityQueue<Person> queue2 = new PriorityQueue<>();
        queue2.add(new Person(5,"5"));
        System.out.println(queue2);
        queue2.add(new Person(4,"4"));
        System.out.println(queue2);
        queue2.add(new Person(3,"3"));
        System.out.println(queue2);
        queue2.add(new Person(2,"2"));
        System.out.println(queue2);
        queue2.add(new Person(1,"1"));
        System.out.println(queue2);
    }
}
