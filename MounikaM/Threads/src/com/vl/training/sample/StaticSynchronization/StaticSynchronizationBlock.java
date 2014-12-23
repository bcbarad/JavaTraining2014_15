package com.vl.training.sample.StaticSynchronization;

public class StaticSynchronizationBlock {
    public static synchronized void display(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

    }
    public static void main(String[] args) {
        StaticSynchronizationBlock st = new StaticSynchronizationBlock();

        FirstThread ft = new FirstThread(st);
        SecondThread s = new SecondThread(st);

        ft.start();
        s.start();
        try {
            ft.join();
            s.join();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
