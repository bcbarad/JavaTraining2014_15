package com.vl;
class Variable {
    private int a = 1;
    synchronized void increment() {
        a = a + 1;
        System.out.println("a after incrementation" + a);
    }
}
class Thread1 extends Thread {
    private Variable v;
    public Thread1(final Variable v) {
        this.v = v;
    }
    public void run() {
        v.increment();
    }
}
public class ThreadSample2 extends Thread {
    public static void main(final String[] args) {
        Variable v = new Variable();
        Thread1 t1 = new Thread1(v);
        Thread1 t2 = new Thread1(v);
        t1.start();
        t2.start();
    }
}
