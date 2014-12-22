package com.vl.training.sample;

public class FirstThread extends Thread {
    SynchronizationExample1 se;
    FirstThread(SynchronizationExample1 se) {
        this.se = se;
    }
    public void run() {
        se.display(10);
    }
}

