package com.vl.sf.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Transaction extends Thread {

	protected static ConcurrentMap<Long, Bank> storageFile = new ConcurrentHashMap<Long, Bank>();

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

	public static synchronized void setTotalAmountDetails(BufferedReader bReader)
			throws IOException {
		String record;
		while ((record = bReader.readLine()) != null) {
			String[] temp = record.split(",");
			if (temp.length != 0) {
				boolean status = false;
				long accNo = Long.parseLong(temp[0]);
				String transactionType = temp[1];
				double amount = Double.parseDouble(temp[2]);
				Bank bank = storageFile.get(accNo);
				/*
				 * If there is no accounts previously and trying to deposit the
				 * money then we are creating an account and deposit the amount
				 */
				if (bank == null) {
					bank = new Bank();
					status = bank.deposit(amount);
					if (status) {
						storageFile.put(accNo, bank);
					} else {
						System.out
								.println("We cannot open an account with Rs.000");
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
					synchronized (bank) {
						if (transactionType.equals("d")
								|| transactionType.equals("D")) {
							status = bank.deposit(amount);
							if (!status) {
								System.out
										.println("Rs.000 is not possible to deposit in your account");
							}
						} else if (transactionType.equals("w")
								|| transactionType.equals("W")) {
							status = bank.withdraw(amount);
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
			Map.Entry<Long, Bank> entry = (Entry<Long, Bank>) iterator.next();
			System.out.println("Balance of " + entry.getKey() + " is : "
					+ entry.getValue().amount);
		}
	}

	public static void main(String[] args) {
		try {
			if (args.length == 3) {

				BufferedReader file1Reader = new BufferedReader(new FileReader(
						args[0]));
				file1Reader.readLine();
				Transaction tran1 = new Transaction(file1Reader);

				BufferedReader file2Reader = new BufferedReader(new FileReader(
						args[1]));
				file2Reader.readLine();
				Transaction tran2 = new Transaction(file2Reader);

				BufferedReader file3Reader = new BufferedReader(new FileReader(
						args[2]));
				file3Reader.readLine();
				Transaction tran3 = new Transaction(file3Reader);
				System.out.println("Thread one is going to start");
				tran1.start();
				System.out.println("Thread two is going to start");
				tran2.start();
				System.out.println("Thread three is going to start\n");
				tran3.start();

				Thread.sleep(1000);

				transactionSummary();
			}else {
				System.out.println("You have not given the Commandline argument values");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

