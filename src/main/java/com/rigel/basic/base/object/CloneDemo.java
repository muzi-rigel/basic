package com.rigel.basic.base.object;

class Person implements Cloneable { //clone()是Object类中的protected成员方法。继承Cloneable只是为了运行时不要报异常。
    private int age ;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {}

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    /*
     * 这里必须要复写Object类的clone()方法，原因：
     * Object类中的clone()方法是protected权限，只能在本包中或者在其它包的子类中访问(注意是子类中)
     * 这里重写一下，虽然还是protected的，但是可以在本包中访问了。
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


public class CloneDemo {
    public static void main(String args[]) {
        Person p = new Person(23, "zhang");
        Person p1 = null;
        try {
            p1 = (Person) p.clone(); //非子类中访问clone()方法
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        if (p1 != null) {
            System.out.println(p); //若引用的是同一个类，打印的hash值是一样的，clone的是不同的
            System.out.println(p1);

            //结果
            //com.rigel.basic.base.object.Person@f6f4d33
            //com.rigel.basic.base.object.Person@23fc625e
        }
    }
}