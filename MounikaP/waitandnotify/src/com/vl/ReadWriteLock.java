package com.vl;
interface RWLock {
    abstract public void readLock() throws InterruptedException;
    abstract public void releaseReadLock() throws InterruptedException;
    abstract public void writeLock() throws InterruptedException;
    abstract public void releaseWriteLock() throws InterruptedException;
}
class ReadWriteLock implements RWLock {
    private int readers = 0;
    private int writers = 0;
    private Object o = new Object();
    public void readLock() throws InterruptedException {
        synchronized(o) {
            while (writers > 0) {
                o.wait();
            }
            readers++;
        }
    }
    public void releaseReadLock() throws InterruptedException {
        synchronized(o) {
            readers--;
            o.notifyAll();
        }
    }
    public void writeLock() throws InterruptedException {
        synchronized(o) {
            while ((readers > 0) || (writers > 0)) {
                o.wait();
            }
            writers++;
        }
    }
    public void releaseWriteLock() throws InterruptedException {
        synchronized(o) {
            writers--;
            o.notifyAll();
        }
    }
}
