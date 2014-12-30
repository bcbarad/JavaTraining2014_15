package com.vl.sf.core;

public class ReadWriteLockImpl implements ReadWriteLock {
	private static boolean isWritting = false;

	@Override
	public synchronized void getWriteLock() throws InterruptedException {
		synchronized (ReadWriteLockImpl.class) {
			while (isWritting) {
				System.out.println("writting is going on waiting "
						+ Thread.currentThread().getName());
				ReadWriteLockImpl.class.wait();
				System.out.println("waiting is over "
						+ Thread.currentThread().getName());
			}
			isWritting = true;
			System.out.println(Thread.currentThread().getName()
					+ " U can write now ");
		}

	}

	@Override
	public void getReadLock() throws InterruptedException {
		synchronized (this) {
			if (!isWritting) {
				System.out.println("U can read "
						+ Thread.currentThread().getName());
			} else {
				System.out.println("waiting for reading "
						+ Thread.currentThread().getName());
				wait();
				System.out.println("U can read "+ Thread.currentThread().getName());
			}
		}

	}

	@Override
	public synchronized void releaseLock() {
		if (!isWritting) {
			synchronized (this) {
				if (!isWritting) {
					notifyAll();
				} else {
					isWritting = false;
					notifyAll();
				}
			}

		} else {
			synchronized (ReadWriteLockImpl.class) {
				if (!isWritting) {
					ReadWriteLockImpl.class.notifyAll();
				} else {
					isWritting = false;
					ReadWriteLockImpl.class.notifyAll();
				}
			}
		}

	}

}
