package com.vl;
class Print {
    synchronized void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println("value" + i);
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread1 extends Thread {
    private Print p;
    public Thread1(final Print p) {
        this.p = p;
    }
    public void run() {
        p.print();
    }
}
public class ThreadSample2 extends Thread {
    public static void main(final String[] args) {
        Print p = new Print();
        Thread1 t = new Thread1(p);
        Thread1 t1 = new Thread1(p);
        t.start();
        t1.start();
        try {
            t.join();
            t1.join();
        } catch (Exception e) {
            System.out.println("interrupted");
        }
    }
}
