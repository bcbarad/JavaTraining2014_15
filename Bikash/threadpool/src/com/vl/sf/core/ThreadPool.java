package com.vl.sf.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	@SuppressWarnings("rawtypes")
	private static BlockingQueue taskQueue = null;
	private List<Worker> workerThreads;
	private boolean isStopped = false;

	// Start N Threads and keep them running
	public ThreadPool(int noOfThreads, int maxNoOfTasks)
			throws InterruptedException {
		taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
		workerThreads = new ArrayList<>();

		for (int i = 0; i < noOfThreads; i++) {
			workerThreads.add(new Worker());
			workerThreads.get(i).start();
		}
	}

	public void stop() {
		try {
			while (!taskQueue.isEmpty()) {
				Thread.sleep(100);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		isStopped = true;
		for (Thread workerThread : workerThreads) {
			workerThread.interrupt();
		}
	}

	@SuppressWarnings("unchecked")
	public void addTask(Runnable r) {
		try {
			taskQueue.put(r);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void init(File[] allFiles) throws IOException,
			InterruptedException {
		ThreadPool pool = new ThreadPool(2, 50);
		BufferedReader file1Reader = null;
		int fileLength = allFiles.length;
		for (int i = 0; i < fileLength; i++) {
			file1Reader = new BufferedReader(new FileReader(allFiles[i]));
			file1Reader.readLine();
			pool.addTask(new Transaction(file1Reader));
		}
		pool.stop();
	}

	public class Worker extends Thread {
		@Override
		public void run() {
			while (!isStopped) {
				try {
					// each thread wait for next runnable and executes it's run
					// method
					Runnable r = (Runnable) taskQueue.take();
					r.run();
				} catch (InterruptedException e) {
					// ignore
				}
			}

		}

	}

}

