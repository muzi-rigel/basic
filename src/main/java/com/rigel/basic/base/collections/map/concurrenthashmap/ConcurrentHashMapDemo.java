package com.rigel.basic.base.collections.map.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(17,17);

    }
}
