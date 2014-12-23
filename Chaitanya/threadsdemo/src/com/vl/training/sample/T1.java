package com.vl.training.sample;
class T1 extends Thread {
    private C c;
    T1(final C c) {
        this.c = c;
        Thread t1 = new Thread();
       // t1.start();
    }
    public void run() {
        c.f1();
    }
}
