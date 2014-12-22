package com.vl.training.sample;


class SecondThread extends Thread {
    SynchronizationExample1 se;
    public SecondThread(SynchronizationExample1 se) {
        this.se = se;
    }

    public void run() {
        se.display(20);
    }
}
