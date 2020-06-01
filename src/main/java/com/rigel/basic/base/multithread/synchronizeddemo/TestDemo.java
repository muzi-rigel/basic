package com.rigel.basic.base.multithread.synchronizeddemo;

public class TestDemo {

    /**
     * javap -verbose *.class 有两对monitorenter 
     */
    public void syncsTask(){
        synchronized (this){
            System.out.println(1);
            synchronized (this){
                System.out.println(2);
            }
        }
    }
}
