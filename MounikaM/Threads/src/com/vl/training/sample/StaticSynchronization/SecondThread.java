package com.vl.training.sample.StaticSynchronization;

public class SecondThread extends Thread {
    StaticSynchronizationBlock st;

    public SecondThread(StaticSynchronizationBlock s){
        this.st = s;
    }
    public void run() {
        StaticSynchronizationBlock.display(25);
    }
}

