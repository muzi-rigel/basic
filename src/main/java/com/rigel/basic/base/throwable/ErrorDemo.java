package com.rigel.basic.base.throwable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ErrorDemo {

    @Test
    public void sofDemo(){
        method();
    }

    private void method() {
        for (;;){
            method();
        }
    }

    @Test
    public void OomDemo(){
        List list = new ArrayList();
        for (;;){
            int[] tmp = new int[10000000];
            list.add(tmp);
        }
    }

}
