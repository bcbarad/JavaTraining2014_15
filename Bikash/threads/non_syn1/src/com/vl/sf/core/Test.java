package com.vl.sf.core;
public class Test{
    public static void main(String[] args){
        Add a=new Add();
        System.out.println("Calling Thread 1");
        new Thread1(a).start();
        System.out.println("Calling Thread 2");
        new Thread2(a).start();
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

