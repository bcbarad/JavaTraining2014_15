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
		try {
			ReadWriteLockImpl.getReadLock();
			reader = new BufferedReader(new FileReader(file));
			System.out.println(Thread.currentThread().getName()+"'s Reading is started ");
			while ((line =reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(Thread.currentThread().getName()+"'s Reading is over ");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (FileNotFoundException fnoe) {
			fnoe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			ReadWriteLockImpl.getReadUnLock();
		}
	}

	@Override
	public void run() {
		readFile();
	}

}
