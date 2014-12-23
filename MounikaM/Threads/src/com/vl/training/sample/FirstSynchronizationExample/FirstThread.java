package com.vl.training.sample.FirstSynchronizationExample;
class FirstThread extends Thread {
    SynchronizationExample se;
    public FirstThread(SynchronizationExample se) {
        this.se = se;
    }
    public void run() {
        se.display(20);
    }
}
