package com.vl.training.sample.SynchronizationExample1;

public class SecondThread extends Thread {
    private SynchronizationEx1 syn;

    public SecondThread(final SynchronizationEx1 syn) {

        this.syn = syn;
    }

    public void run() {
        SynchronizationEx1 s = new SynchronizationEx1();
        s.multiplicationTable(7);
    }
}

