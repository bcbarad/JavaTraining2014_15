package com.vl.training.sample.StaticSynchronization;

public class SecondThread extends Thread {
    private StaticSynchronizationBlock st;

    public SecondThread(final StaticSynchronizationBlock s) {
        this.st = s;
    }
    public void run() {
        StaticSynchronizationBlock.display(25);
    }
}

