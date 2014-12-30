package com.vl.sf.core;

public interface ReadWriteLock {
	public void getWriteLock()throws InterruptedException;
	public void getReadLock()throws InterruptedException;
	public void releaseLock();
}
