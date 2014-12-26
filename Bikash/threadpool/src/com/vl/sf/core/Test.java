package com.vl.sf.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {

		try {
			if (args.length != 0) {
				File inputDirectory = new File(args[0]);
				File[] allFiles = inputDirectory.listFiles();
				ThreadPool.init(allFiles);
				Transaction.transactionSummary();
			} else {
				System.out
						.println("You have not given the Commandline argument values");
			}
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}







