package com.vl.sf.core;

public class ReadWriteLockImpl {

	private static int readers = 0;
	private static int writers = 0;

	public static synchronized void getReadLock() throws InterruptedException {
		while (writers > 0 ) {
			ReadWriteLockImpl.class.wait();
	@Override
	public void getReadLock() throws InterruptedException {
		synchronized (object) {
			if (!isWritting) {
				System.out.println("U can read "
						+ Thread.currentThread().getName());
			} else {
				System.out.println(Thread.currentThread().getName()+" waiting for writting ");
				while(isWritting){
					object.wait(100);
				}
			}
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
	@Override
	public void releaseLock() {

		synchronized (object) {
			if (isWritting) {
				System.out.println(Thread.currentThread().getName()+" read lock Realesed");
				object.notifyAll();
			} else {
				System.out.println(Thread.currentThread().getName()+" write lock Realesed ");
				isWritting = false;
				object.notifyAll();
			}
		}
		writers++;
	}

	public static synchronized void getWriteUnLock() {
		writers--;
		ReadWriteLockImpl.class.notifyAll();
	}

}
