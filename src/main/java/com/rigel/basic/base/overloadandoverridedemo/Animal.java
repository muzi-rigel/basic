package com.rigel.basic.base.overloadandoverridedemo;

import java.io.IOException;

public interface Animal {


    int getAge(int a,String b);

    Meat getFood() throws IOException;
}
