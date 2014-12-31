package com.vl.sf.core;

public class Test {
	public static void main(String[] args) {
		if (args.length > 0) {
			Thread[] threads = new Thread[10];
			Thread[] threads1 = new Thread[10];
			for (int i = 0; i < threads.length; i++) {
				threads[i] = new Thread(new Reader(args[0]));
				threads1[i] = new Thread(new Writer(args[0]));
				threads[i].start();
				threads1[i].start();
			}
			for (int i = 0; i < threads1.length; i++) {
				try {
					threads1[i].join();
					threads[i].join();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}

			}

		} else {
			System.out.println("Give the command line argument");
		}

	}
}
