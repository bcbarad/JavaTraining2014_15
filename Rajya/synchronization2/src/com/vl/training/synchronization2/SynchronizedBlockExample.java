package com.vl.training.synchronization2;

class SynchronizedBlock {

    void printNumber() {
        synchronized (this) {
            System.out.println("Synchronizedblock");
            for (int i = 1; i <= 3; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Thread1 extends Thread {

    private SynchronizedBlock sb;

    Thread1(final SynchronizedBlock s) {
        this.sb = s;
    }
    public void run() {
        sb.printNumber();
    }
}

class Thread2 extends Thread {

    private SynchronizedBlock sb;

    Thread2(final SynchronizedBlock s) {
        this.sb = s;
    }
    public void run() {
        sb.printNumber();
    }
}

public final class SynchronizedBlockExample {

    private SynchronizedBlockExample() {
    }

    public static void main(final String []args) {
        SynchronizedBlock sb = new SynchronizedBlock();
        Thread1 t1 = new Thread1(sb);
        Thread2 t2 = new Thread2(sb);
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
