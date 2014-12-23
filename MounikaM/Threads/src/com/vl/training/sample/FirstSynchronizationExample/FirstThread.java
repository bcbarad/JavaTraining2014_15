package com.vl.training.sample.SynchronizationExample;
class FirstThread extends Thread {
    SynchronizationExample se;
    public FirstThread(SyncrhonizationExample se) {
        this.se = se;
    }
    public void run() {
        se.display(20);
    }
}
