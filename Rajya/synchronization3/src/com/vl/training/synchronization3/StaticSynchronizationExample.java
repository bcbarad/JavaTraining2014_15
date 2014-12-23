package com.vl.training.synchronization3;

class StaticSynchronization {

    static synchronized void printNumber(final int n) {
        for (int i = 1; i <= 4; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread1 extends Thread {

    private StaticSynchronization stm;

    Thread1(final Object st) {
        this.stm = (StaticSynchronization) st;
    }
    public void run() {
        StaticSynchronization.printNumber(7);
    }
}

class Thread2 extends Thread {

    private StaticSynchronization stm;

    Thread2(final Object st) {
        this.stm = (StaticSynchronization) st;
    }
    public void run() {
        StaticSynchronization.printNumber(5);
    }
}

public final class StaticSynchronizationExample {

    private StaticSynchronizationExample() {
    }

    public static void main(final String []args) {
        StaticSynchronization st = new StaticSynchronization();
        Thread1 t1 = new Thread1(st);
        StaticSynchronization st2 = new StaticSynchronization();
        Thread2 t2 = new Thread2(st2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
