package com.vl.training.sample;

class SyncMethod extends Thread {
    synchronized void print(int n) {
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

public class ThreadEx {
    public static void main(String[] arr) {
        System.out.println("Synchronized methods");
        final SyncMethod obj = new SyncMethod();
        Thread t1 = new Thread() {
            public void run() {
               obj.print(5);
            }
        };
        Thread t2 = new Thread(){
            public void run() {
                obj.print(7);
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
