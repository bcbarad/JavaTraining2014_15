package com.vl.training.waitandnotify;

public interface ReadWriteLock {

    void getWriteLock() throws InterruptedException;
    void getReadLock() throws InterruptedException;
    void releaseLock();
}

