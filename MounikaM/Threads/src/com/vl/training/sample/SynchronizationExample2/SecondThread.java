package com.vl.training.sample;

public class SecondThread extends Thread {
    SynchronizationEx2 syn;

    public SecondThread(SynchronizationEx2 s) {
        this.syn = s;
    }

    public void run() {
        syn.displayGreeting("Hello");
    }
}
