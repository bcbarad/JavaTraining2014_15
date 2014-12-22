package com.vl.training.sample;

class StaticSynchronization extends Thread {
    synchronized static void print(int n) {
        for (int j = 1; j <= 5; j++) {
            System.out.println(n*j);
            try {
                Thread.sleep(n*100);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadEx2 {
    public static void main(String[] arr) {
        System.out.println("Static Synchronized");
        final StaticSynchronization obj = new StaticSynchronization();
        Thread t1 = new Thread() {
            public void run() {
               obj.print(5);
            }
        };
        final StaticSynchronization obj2 = new StaticSynchronization();
        Thread t2 = new Thread(){
            public void run() {
                obj2.print(7);
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
