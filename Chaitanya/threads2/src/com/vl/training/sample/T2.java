package com.vl.training.sample;
class T2 extends Thread {
    private C c;
    T2(final C c) {
        this.c = c;
        Thread t1 = new Thread();
//        t1.start();
    }
    public void run() {
        c.f2();
    }
}
