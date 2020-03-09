package com.rigel.basic.base.collections.hashMap;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashMapToSychronizedMap {

    public static void main(String[] args) {

        Map map = new HashMap();
        ExecutorService service = Executors.newFixedThreadPool(10);

        Map newMap = Collections.synchronizedMap(map);



    }
}
