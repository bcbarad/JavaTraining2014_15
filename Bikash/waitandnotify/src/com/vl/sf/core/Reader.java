package com.vl.sf.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Runnable {
	private String file = null;

	public Reader(String file) {
		this.file = file;
	}

	public void readFile() {
		String line;
		BufferedReader reader = null;
		ReadWriteLock readWriteLock = null;
		try {
			readWriteLock = new ReadWriteLockImpl();
			readWriteLock.getReadLock();
			reader = new BufferedReader(new FileReader(file));
			System.out.println("Reading is going on "+Thread.currentThread().getName());
			if ((line =reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("Reading is over "+Thread.currentThread().getName());
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (FileNotFoundException fnoe) {
			fnoe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			readWriteLock.releaseLock();
		}
	}

	@Override
	public void run() {
		readFile();
	}

}
