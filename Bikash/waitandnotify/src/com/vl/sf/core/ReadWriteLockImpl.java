package com.vl.sf.core;

public class ReadWriteLockImpl implements ReadWriteLock {
	private static boolean isWritting = false;
	private static ReadWriteLock object = new ReadWriteLockImpl();

	@Override
	public void getWriteLock() throws InterruptedException {
		synchronized (object) {
			while (isWritting) {
				System.out.println(Thread.currentThread().getName()+" is waiting for writting");
				object.wait(100);
				System.out.println(Thread.currentThread().getName()+"'s waiting is over ");
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
				System.out.println(Thread.currentThread().getName()+" waiting for writting ");
				while(isWritting){
					object.wait(100);
				}
			}
		}

	}

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
	}

}
