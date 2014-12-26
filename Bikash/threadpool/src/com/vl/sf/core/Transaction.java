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

	protected static ConcurrentMap<Long, Account> map = new ConcurrentHashMap<Long, Account>();

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
				long accNo = Long.parseLong(temp[0]);
				String transactionType = temp[1];
				double amount = Double.parseDouble(temp[2]);
				Account account = map.get(accNo);
				/*
				 * If there is no accounts previously and trying to deposit the
				 * money then it's creating an account and deposit the amount
				 */
				if (account == null) {
					synchronized (map) {
						/*
						 * Suppose two same account threads are came at same
						 * time So May be after entering to the synchronized
						 * block one thread create a new account and putting the
						 * amount after that second thread account object still
						 * containing null account for avoiding this problem
						 * again need to check the account with same accNo
						 */
						account = map.get(accNo);
						if (account == null) {
							account = new Account();
							if (transactionType.equals("d")
									|| transactionType.equals("D")) {

								if (!account.deposit(amount)) {
									System.out
											.println("Rs.000 is not possible to deposit in your account");
								} else {
									map.put(accNo, account);
								}// inner if else
							} else {
								System.out.println(accNo
										+ " Wrong user trying to withdraw Rs."
										+ amount);
							}// outer if else
						} else {
							depositAndWithdraw(accNo, account, transactionType,
									amount);
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
					synchronized (account) {
						depositAndWithdraw(accNo, account, transactionType,
								amount);
					}// synchronized
				}// else
			}// if
		}// while
	}// setTotalAmountDetails

	private static boolean depositAndWithdraw(long accNo, Account account,
			String transactionType, double amount) {
		boolean status = false;
		if (transactionType.equals("d") || transactionType.equals("D")) {
			status = account.deposit(amount);
			if (!status) {
				System.out
						.println("Rs.000 is not possible to deposit in your account");
			}
		} else if (transactionType.equals("w") || transactionType.equals("W")) {
			status = account.withdraw(amount);
			if (!status) {
				System.out.println(accNo
						+ " You have insufficient balance to withdraw Rs."
						+ amount);
			}
		}

		return true;

	}


	@SuppressWarnings("unchecked")
	public static void transactionSummary() {
		Iterator<?> iterator = map.entrySet().iterator();
		System.out.println("\nTRANSACTION SUMMARY");
		System.out.println("===================");
		while (iterator.hasNext()) {
			Map.Entry<Long, Account> entry = ((Entry<Long, Account>) iterator
					.next());
			System.out.println("Balance of " + entry.getKey() + " is : "
					+ entry.getValue().amount);
		}
	}
	
}

