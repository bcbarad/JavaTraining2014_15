package com.vl.sf.core;

public class ReadWriteLockImpl {

	private static int readers = 0;
	private static int writers = 0;

	public static synchronized void getReadLock() throws InterruptedException {
		while (writers > 0 ) {
			ReadWriteLockImpl.class.wait();
		}
		readers++;
	}

	public synchronized static void getReadUnLock() {
		readers--;
		ReadWriteLockImpl.class.notifyAll();
	}

	public static synchronized void getWriteLock() throws InterruptedException {

		while (readers > 0 || writers > 0) {
			ReadWriteLockImpl.class.wait();
		}
		writers++;
	}

	public static synchronized void getWriteUnLock() {
		writers--;
		ReadWriteLockImpl.class.notifyAll();
	}

}
