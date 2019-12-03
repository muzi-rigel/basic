package com.rigel.basic.base.collections.treeSet;

import java.util.Set;
import java.util.TreeSet;

public class DuplicateAndOrderTest {

    public static void main(String[] args) {

        Set<Customer> set = new TreeSet<Customer>();
        set.add(new Customer("b", 25));
        set.add(new Customer("f", 66));
        set.add(new Customer("a", 33));
        set.add(new Customer("a", 22));
        set.add(new Customer("a", 24));
        set.add(new Customer("d", 18));
        set.add(new Customer("c", 44));
        set.add(new Customer("e", 3));
        for (Customer customer : set) {
            System.out.println(customer.getName() + "-" + customer.getAge());
        }
    }
}
