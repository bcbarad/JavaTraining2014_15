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
		ReadWriteLock readWrite = new ReadWriteLockImpl();
		try {
			readWrite.getWriteLock();
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(file, true)));
			System.out.println("writing is going on "
					+ Thread.currentThread().getName());
			out.println("hello");
			System.out.println("writing is over "
					+ Thread.currentThread().getName());
			out.close();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			readWrite.releaseLock();
		}
	}

	@Override
	public void run() {
		writeFile();
	}

}
