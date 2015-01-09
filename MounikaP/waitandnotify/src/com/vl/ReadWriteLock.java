package com.vl;
interface RWLock {
    abstract public void readLock() throws InterruptedException;
    abstract public void releaseReadLock() throws InterruptedException;
    abstract public void writeLock() throws InterruptedException;
    abstract public void releaseWriteLock() throws InterruptedException;
}
class ReadWriteLock implements RWLock {
    private static int readers = 0;
    private static boolean writers = false;
    private Object o = new Object();
    public void readLock() throws InterruptedException {
        synchronized(o) {
            if (writers) {
                o.wait();
            }
            readers++;
            //writers = false;
        }
    }
    public void releaseReadLock() throws InterruptedException {
        synchronized(o) {
            readers--;
            writers = true;
            o.notifyAll();
        }
    }
    public void writeLock() throws InterruptedException {
        synchronized(o) {
            if ((readers > 0) || writers) {
                o.wait();
            }
            writers = true;
            //writers++;
        }
    }
    public void releaseWriteLock() throws InterruptedException {
        synchronized(o) {
            //writers--;
            writers = false;
            o.notifyAll();
        }
    }
}
