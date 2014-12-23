package com.vl.sf.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Transaction extends Thread {

	protected static ConcurrentMap<Long, Account> storageFile = new ConcurrentHashMap<Long, Account>();

	private BufferedReader bReader = null;

	public Transaction(BufferedReader bReader) {
		this.bReader = bReader;
	}

	@Override
	public void run() {
		try {
			setTotalAmountDetails(bReader);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public void setTotalAmountDetails(BufferedReader bReader)
			throws IOException {
		String record;
		while ((record = bReader.readLine()) != null) {
			String[] temp = record.split(",");
			if (temp.length != 0) {
				boolean status = false;
				long accNo = Long.parseLong(temp[0]);
				String transactionType = temp[1];
				double amount = Double.parseDouble(temp[2]);
				Account value = storageFile.get(accNo);
				/*
				 * If there is no accounts previously and trying to deposit the
				 * money then we are creating an account and deposit the amount
				 */
				if (value == null) {
					synchronized (storageFile) {
						value = new Account();
						if (transactionType.equals("d")
								|| transactionType.equals("D")) {
							status = value.deposit(amount);
							if (!status) {
								System.out
										.println("Rs.000 is not possible to deposit in your account");
							}else {
								storageFile.put(accNo, value);
							}
						} else {
							System.out.println(accNo + " Does not have account trying to withdraw Rs."+amount);
						}
					}
				} else {
					/*
					 * If the account is exist and trying to do a transaction
					 * then here checking the deposit amount, if the deposit
					 * amount is 000 then the deposit method returns false. else
					 * it's depositing the amount by locking the object of
					 * deposit and withdraw method If user wants to withdraw the
					 * amount withdraw method checks the the given amount should
					 * not greater that the balanced amount then it's
					 * withdrawing the amount else the method returns false and
					 * gives a insufficient balance message
					 */
					synchronized (value) {
						if (transactionType.equals("d")
								|| transactionType.equals("D")) {
							status = value.deposit(amount);
							if (!status) {
								System.out
										.println("Rs.000 is not possible to deposit in your account");
							}
						} else if (transactionType.equals("w")
								|| transactionType.equals("W")) {
							status = value.withdraw(amount);
							if (!status) {
								System.out
										.println(accNo
												+ " You have insufficient balance to withdraw Rs."
												+ amount);
							}
						}// else if
					}// synchronized
				}// else
			}// if
		}// while
	}// setTotalAmountDetails

	public static void transactionSummary() {
		Iterator<?> iterator = storageFile.entrySet().iterator();
		System.out.println("TRANSACTION SUMMARY");
		System.out.println("===================");
		while (iterator.hasNext()) {
			Map.Entry<Long, Account> entry = (Entry<Long, Account>) iterator
					.next();
			System.out.println("Balance of " + entry.getKey() + " is : "
					+ entry.getValue().amount);
		}
	}

	public static void main(String[] args) {

		try {
			if (args.length != 0) {
				File inputDirectory = new File(args[0]);
				File[] allFiles = inputDirectory.listFiles();
				int fileLength = allFiles.length;
				Transaction[] transactions = new Transaction[fileLength];
				BufferedReader file1Reader = null;
				for (int i = 0; i < fileLength; i++) {
					file1Reader = new BufferedReader(
							new FileReader(allFiles[i]));
					file1Reader.readLine();
					transactions[i] = new Transaction(file1Reader);
					transactions[i].start();
				}
				for (int i = 0; i < fileLength; i++) {
					transactions[i].join();
				}
				transactionSummary();
			} else {
				System.out
						.println("You have not given the Commandline argument values");
			}
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

