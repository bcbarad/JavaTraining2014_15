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
			//System.out.println(record+"\n");
			if (temp.length != 0) {
				boolean status=false;
				long accNo = Long.parseLong(temp[0]);
				String transactionType = temp[1];
				double amount = Double.parseDouble(temp[2]);
				Bank bank = storageFile.get(accNo);
				if (bank == null) {
					bank = new Bank();
					status=bank.deposit(amount);
					if(status){
						storageFile.put(accNo, bank);
					}
				} else {
					synchronized (bank) {
						if (transactionType.equals("d")
								|| transactionType.equals("D")) {
							status=bank.deposit(amount);
						} else if (transactionType.equals("w")
								|| transactionType.equals("W")) {
							status=bank.withdraw(amount);
							if(!status){
								System.out.println(accNo+" You have insufficient balance to withdraw Rs."+amount);
							}
						}//else if
					}// synchronized
				}//else
			}// if
		}// while
	}//setTotalAmountDetails

	public static void transactionSummary() {
		Iterator<?> iterator = storageFile.entrySet().iterator();
		System.out.println("TRANSACTION SUMMARY");
		System.out.println("===================");
		while (iterator.hasNext()) {
			Map.Entry<Integer, Bank> entry = (Entry<Integer, Bank>) iterator.next();
			System.out.println("Balance of "+entry.getKey()+" is : "+ entry.getValue().amount);
		}
	}

	public static void main(String[] args) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

