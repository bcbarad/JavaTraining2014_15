package com.vl.training.waitandnotify;

public class ReadWriteReleaseLocks implements ReadWriteLock {

    private boolean isReading = true;
    private static ReadWriteReleaseLocks obj = new ReadWriteReleaseLocks();

    public final void getWriteLock() throws InterruptedException {
        synchronized (obj) {
            if (!isReading) {
                System.out.println("waiting for writing");
                obj.wait();
                System.out.println("waiting is completed");
            }
            isReading = true;
            System.out.println("writing is allowed");
        }
    }

    public final void getReadLock() throws InterruptedException {
        synchronized (obj) {
            if (isReading) {
                System.out.println("read can be performed");
            } else {
                System.out.println("waiting for writing");
                obj.wait();
                System.out.println("write lock released");
            }
        }
    }

    public final void releaseLock() {
        synchronized (obj) {
            if (isReading) {
                obj.notify();
                System.out.println("releaseLock applied on readLock");
            } else {
                obj.notify();
                System.out.println("releaseLock applied on writeLock");
            }
        }
    }
}
