package com.vl.training.sample;

public class FirstThread extends Thread {
    private SynchronizationEx2 syn;

    public FirstThread(final SynchronizationEx2 s) {
        this.syn = s;
    }

    public void run() {
        syn.display(10);
    }
}
