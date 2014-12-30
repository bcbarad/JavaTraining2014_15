package com.vl.sf.core;

public class ReadWriteLockImpl implements ReadWriteLock {
	private static boolean isWritting = false;
	private Object object=ReadWriteLockImpl.class;

	@Override
	public void getWriteLock() throws InterruptedException {
		synchronized (object) {
			if (isWritting) {
				System.out.println("writting is going on waiting "
						+ Thread.currentThread().getName());
				object.wait();
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
		synchronized (object) {
			if (!isWritting) {
				System.out.println("U can read "
						+ Thread.currentThread().getName());
			} else {
				System.out.println("waiting for writting "
<<<<<<< HEAD
						+ Thread.currentThread().getName());
				object.wait();
				System.out.println("U can write "
						+ Thread.currentThread().getName());
=======
						+ Thread.currentThread().getName());
				wait();
				System.out.println("U can write "+ Thread.currentThread().getName());
>>>>>>> a02a16f9089d82799b9f6be0d228532abdffd18a
			}
		}

	}

	@Override
	public void releaseLock() {

		synchronized (object) {
			if (!isWritting) {
				object.notifyAll();
			} else {
				isWritting = false;
				object.notifyAll();
			}
		}
	}

}
