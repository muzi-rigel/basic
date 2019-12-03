package com.rigel.basic.base.collections.treeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CustomerComparator implements Comparator<Customer> {

    /**
     *  两种方式 1、比较器接口 compatator           两种共存时优先
     *          2、自然排序   实现comparable
     *
     */

    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) return 1;
        if (o1.getName().compareTo(o2.getName()) < 0) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Set<Customer> set = new TreeSet<Customer>(new CustomerComparator());
        set.add(new Customer("a", 1));
        set.add(new Customer("a", 2));
        set.add(new Customer("c", 1));
        Iterator<Customer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Customer next = iterator.next();
            System.out.println(next.getName() + "-" + next.getAge());
        }

    }
}
