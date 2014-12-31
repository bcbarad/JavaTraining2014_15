package com.vl.sf.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer implements Runnable {
	private String file = null;

	public Writer(String file) {
		this.file = file;
	}

	public void writeFile() {
		try {
			ReadWriteLockImpl.getWriteLock();
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(file, true)));
			System.out.println(Thread.currentThread().getName()
					+ " Writting is started ");
			out.println("hello");
			System.out.println(Thread.currentThread().getName()
					+ "'s writing is over ");
			out.close();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			ReadWriteLockImpl.getWriteUnLock();
		}
	}

	@Override
	public void run() {
		writeFile();
	}

}
