package com.vl.training.sample.StaticSynchronization;

public class FirstThread extends Thread {
    StaticSynchronizationBlock st;

    FirstThread(StaticSynchronizationBlock s){
        this.st = s;
    }
    public void run() {
        StaticSynchronizationBlock.display(5);
    }
}
