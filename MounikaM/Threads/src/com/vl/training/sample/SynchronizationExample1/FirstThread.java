package com.vl.training.sample.SynchronizationExample1;

public class FirstThread extends Thread {
    SynchronizationEx1 syn;

    public FirstThread(SynchronizationEx1 syn) {
        this.syn = syn;
    }

    public void run() {
        SynchronizationEx1 s = new SynchronizationEx1();
        s.multiplicationTable(4);
    }
}
