package com.vl.training.sample.SynchronizationExample;

class SecondThread extends Thread {
    SynchronizationExample se;
    public SecondThread(SynchronizationExample se) {
        this.se = se;
    }
    public void run() {
        se.display(20);
    }
}
