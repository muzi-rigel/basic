package com.rigel.basic.base.collections.treeSet;

import java.util.Objects;

public class Customer implements Comparable {

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (age != customer.age) return false;
        return name != null ? name.equals(customer.name) : customer.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        Customer other = (Customer) o;
        if (this.name.compareTo(other.name) > 0) {
            return 1;
        }

        if (this.name.compareTo(other.name) < 0) {
            return -1;
        }

        if (this.age - other.age > 0) {
            return 1;
        }

        if (this.age - other.age < 0) {
            return -1;
        }

        return 0;
    }
}
