package com.vl.sf.core;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {

		try {
			if (args.length != 0) {
				//TODO:Give the directory as command line argument where all the files are available to read 
				ThreadPool.init(args[0]);
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







