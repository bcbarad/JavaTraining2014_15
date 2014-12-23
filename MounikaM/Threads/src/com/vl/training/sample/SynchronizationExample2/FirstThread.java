package com.vl.training.sample;

public class FirstThread extends Thread {
    SynchronizationEx2 syn;

    public FirstThread(SynchronizationEx2 s) {
        this.syn = s;
    }

    public void run() {
        syn.display(10);
    }
}
