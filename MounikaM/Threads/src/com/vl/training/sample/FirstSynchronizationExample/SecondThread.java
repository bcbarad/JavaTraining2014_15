package com.vl.training.sample.FirstSynchronizationExample;

class SecondThread extends Thread {
    SynchronizationExample se;
    public SecondThread(SynchronizationExample se) {
        this.se = se;
    }
    public void run() {
        se.display(10);
    }
}
