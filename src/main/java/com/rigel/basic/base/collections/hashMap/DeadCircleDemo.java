package com.rigel.basic.base.collections.hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DeadCircleDemo {

    public static void main(String[] args) throws InterruptedException {


        Entry[] oldTable = new Entry[2];
        oldTable[1] = new Entry(1, 1, 1, new Entry(1, 2, 2, new Entry(1, 3, 3, null)));
        Entry[] newTable = new Entry[4];
        Entry[] newTable2 = new Entry[4];

        System.out.println("主线程开始，参数为:" + getEntryListValue(oldTable[1]));

        // Thread2 先进行 Entry next = e.next;
        new Thread(new Runnable() {
            @Override
            public void run() {
                int firstFlag = 0;
                int newCapacity = newTable.length;
                for (Entry e : oldTable) {
                    while (null != e) {
                        Entry next = e.next;
//                        System.out.println("--------");
//                        System.out.println(getEntryListValue(e));
//                        System.out.println(getEntryListValue(next));
//                        System.out.println("--------");
                        if (firstFlag == 0) {
                            //第一次的时候等待另外的线程一段时间
                            try {
                                System.out.println("线程2等待中..");
                                Thread.sleep(1000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                        System.out.printf("线程2循环1准备 参数为：e={%s}，newTable2[1]={%s}，next={%s}", getEntryListValue(e), getEntryListValue(newTable2[1]), getEntryListValue(next));
                        System.out.println();
                        //rehash
                        int i = e.hash;
                        e.next = newTable2[i];
                        newTable2[i] = e;
                        e = next;
                        System.out.printf("线程2循环1结束 参数为：e={%s}，newTable2[1]={%s}，next={%s}", getEntryListValue(e), getEntryListValue(newTable2[1]), getEntryListValue(next));
                        System.out.println();
                        if (null == e) {
                            System.out.println("e为null,自然跳出循环..");
                        }

                        if (firstFlag++ > 10) {
                            System.out.println("达到最大循环次数 中断程序..");
                            break;
                        }
                    }
                }
            }
        }).start();


        //等待线程2先跑完第一次的Entry next = e.next;
        Thread.sleep(100);
        System.out.println("线程1执行开始。。");
        transfer(newTable, oldTable);
        System.out.println("线程1执行结束。。");
        System.out.println("线程1结果为" + getEntryListValue(newTable[1]));
        Thread.sleep(2000);
        System.out.println(getEntryListValue(newTable2[1]));
    }

    public static String getEntryListValue(Entry entry) {
        if (null == entry) {
            return "null";
        }
        int a = 0;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(entry.getKey() + "," + entry.getValue() + "---");
            entry = entry.next;
            a++;
        } while (entry != null && a < 10);

        return (a >= 10 ? sb.append("DEAD CIRCLE") : sb.append("null")).toString();
    }

    public static String getEntryListValueString(Entry entry) {
        if (null == entry) {
            return "null";
        }
        return entry.getKey() + "," + entry.getValue() + "---" + getEntryListValue(entry.next);
    }


    static void transfer(Entry[] newTable, Entry[] table) {
        int newCapacity = newTable.length;
        for (Entry e : table) {
            while (null != e) {
                Entry next = e.next;
                //rehash
                int i = e.hash;
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        /**
         * Creates new entry.
         */
        Entry(int h, K k, V v, Entry<K, V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
        }


        public final String toString() {
            return getKey() + "," + getValue();
        }


        /**
         * This method is invoked whenever the value in an entry is
         * overwritten by an invocation of put(k,v) for a key k that's already
         * in the HashMap.
         */
        void recordAccess(HashMap<K, V> m) {
        }

        /**
         * This method is invoked whenever the entry is
         * removed from the table.
         */
        void recordRemoval(HashMap<K, V> m) {
        }
    }

}

