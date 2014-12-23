package com.vl.training.sample;

public class SecondThread extends Thread {
    private SynchronizationEx2 syn;

    public SecondThread(final SynchronizationEx2 s) {
        this.syn = s;
    }

    public void run() {
        syn.displayGreeting("Hello");
    }
}
