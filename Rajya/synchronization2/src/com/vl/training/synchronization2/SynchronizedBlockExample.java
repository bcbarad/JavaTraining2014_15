package com.vl.training.synchronization2;

class Thread1 extends Thread {

    private Object obj;

    Thread1(final Object o) {
        this.obj = o;
    }
    public void run() {
        synchronized (this) {
            System.out.println("Thread t1 run method");
            for (int i = 0; i < 3; i++) {
                System.out.println(this.getName());
            }
        }
    }
}

class Thread2 extends Thread {

    private Object obj;

    Thread2(final Object o) {
        this.obj = o;
    }
    public void run() {
         synchronized (this) {
            System.out.println("Thread t2 run method");
            for (int i = 0; i < 3; i++) {
                System.out.println(this.getName());
            }
        }
    }
}

public final class SynchronizedBlockExample {

    private SynchronizedBlockExample() {
    }

    public static void main(final String []args) {
        Object obj = new Object();
        Thread1 t1 = new Thread1(obj);
        Thread2 t2 = new Thread2(obj);
        t1.start();
        t2.start();
    }
}
