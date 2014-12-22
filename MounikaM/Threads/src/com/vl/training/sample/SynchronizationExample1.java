package com.vl.training.sample;


public class SynchronizationExample1 {
    public synchronized void display(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
         }
    }

    public static void main(String[] args) {
        SynchronizationExample1 se = new SynchronizationExample1();
        FirstThread t1 = new FirstThread(se);
        SecondThread t2 = new SecondThread(se);
        t1.start();
        t2.start();
    }
}

