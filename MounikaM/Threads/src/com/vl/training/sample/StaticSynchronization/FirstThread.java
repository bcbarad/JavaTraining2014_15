package com.vl.training.sample.StaticSynchronization;

public class FirstThread extends Thread {
    private StaticSynchronizationBlock st;

    FirstThread(final StaticSynchronizationBlock s) {
        this.st = s;
    }
    public void run() {
        StaticSynchronizationBlock.display(5);
    }
}
