package com.rigel.basic.base.comparabledemo;

public class Person implements Comparable<Person> {

    private Integer id;
    private String name;


    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        int i = this.id > o.getId() ? 1 : (this.id < o.getId() ? -1 : 0);
        System.out.println("compara"+this.id+"-"+o.id + "result="+i);
        return i;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
