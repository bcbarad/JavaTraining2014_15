package com.vl.sf.core;

public class ReadWriteLockImpl {

	private static int readers = 0;
	private static boolean isWritting = false;
	//private static int writeRequests = 0;

	public static synchronized void getReadLock() throws InterruptedException {
		while (isWritting /*|| writeRequests > 0*/) {
			ReadWriteLockImpl.class.wait();
		}
		readers++;
	}

	public synchronized static void getReadUnLock() {
		readers--;
		ReadWriteLockImpl.class.notifyAll();
	}

	public static synchronized void getWriteLock() throws InterruptedException {
		//writeRequests++;

		while (readers > 0 || isWritting) {
			ReadWriteLockImpl.class.wait();
		}
		//writeRequests--;
		isWritting=true;
	}

	public static synchronized void getWriteUnLock() {
		isWritting=false;
		ReadWriteLockImpl.class.notifyAll();
	}

}
