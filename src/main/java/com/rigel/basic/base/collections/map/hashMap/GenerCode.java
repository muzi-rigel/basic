package com.rigel.basic.base.collections.map.hashMap;
public class GenerCode {

    public static void main(String[] args) {

        getMap2();
    }

    private static void getMap2() {
        for (int i1 = 0; i1 < 13; i1++) {
            int num = 15*i1;
            System.out.println("map.put("+num+","+num+");");
        }
    }

    private static void getMap() {
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int i1 = 0; i1 < 7; i1++) {
                sb.append(i);
                Integer num = Integer.parseInt(sb.toString());
                System.out.println("map.put("+num+","+num+");");
            }
        }
    }
}
