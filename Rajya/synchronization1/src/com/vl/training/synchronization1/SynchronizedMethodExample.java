package com.vl.training.synchronization1;

class Calculation {

    synchronized void printTables(final int number) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(number * i);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Thread1 extends Thread {

    private Calculation c;

    Thread1(final Calculation cal) {
        this.c = cal;
    }

    public void run() {
        c.printTables(2);
    }
}

class Thread2 extends Thread {

    private Calculation c;

    Thread2(final Calculation cal) {
        this.c = cal;
    }

    public void run() {
        c.printTables(5);
    }
}

public final class SynchronizedMethodExample {

    private SynchronizedMethodExample() {
    }

    public static void main(final String []args) {
        Calculation cal = new Calculation();
        Thread1 t1 = new Thread1(cal);
        Thread2 t2 = new Thread2(cal);
        t1.start();
        t2.start();
    }
}
