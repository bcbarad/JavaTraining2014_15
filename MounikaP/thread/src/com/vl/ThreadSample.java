package com.vl;
//import java.io.*;
//import java.lang.Thread;
class Variable {
    private int a = 1;
    /*public Variable(Object o) {
        this.o = o;
    }*/
    public void increment(final Object o) {
        synchronized (o) {
            a = a + 1;
            System.out.println("a value after incrementation"  + a);
        }
    }
}
class Variable1 {
    private int a = 1;
    /*public Variable1(Object o) {
        this.o = o;
    }*/
    public void decrement(final Object o) {
        synchronized (o) {
            a = a - 1;
            System.out.println("a value after decrementation"  + a);
        }
    }
}
public class ThreadSample extends Thread {
    public static void main(final String[] args) {
        Object o = new Object();
        Variable v1 = new Variable();
        Variable1 v2 = new Variable1();
        v1.increment(o);
        v2.decrement(o);
        Thread t = new Thread();
        t.start();
    }
}





