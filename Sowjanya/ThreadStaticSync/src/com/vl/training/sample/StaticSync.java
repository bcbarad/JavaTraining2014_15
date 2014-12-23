package com.vl.training.sample;
class Numerics {
    synchronized static void display(final int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.print("\n");
    }
}
class Thread1 extends Thread {
    Numerics n;
    Thread1(final Numerics n) { 
        this.n = n;
    }
    public void run() {
        n.display(10);
    }
}
class Thread2 extends Thread {
    Numerics n;
    Thread2(final Numerics n) {
        this.n = n;
    }
    public void run() {
        n.display(10);
    }
}
final public class StaticSync {
    private StaticSync() {
    }
    public static void main(final String[] args) {
        Numerics n = new Numerics();
        Thread1 t1 = new Thread1(n);
        Thread2 t2 = new Thread2(n);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
