package com.vl;
class Variable {
    private int a = 1;
    void increment() {
        synchronized (this) {
            a = a + 1;
            System.out.println("a after incrementation" + a);
        }
    }
}
class Thread1 extends Thread {
    private final Variable v;
    public Thread1(final Variable v) {
        this.v = v;
    }
    public void run() {
        v.increment();
    }
}
public class ThreadSample1 extends Thread {
    public static void main(final String[] args) {
        Variable v = new Variable();
        Thread1 t = new Thread1(v);
        Thread1 t1 = new Thread1(v);
        t.start();
        t1.start();
    }
}

