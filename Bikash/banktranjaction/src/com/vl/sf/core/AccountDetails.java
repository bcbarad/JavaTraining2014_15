package com.vl.sf.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AccountDetails {
	public Map<Long, Double> totalAmountDetails(BufferedReader bReader)
			throws IOException {
		Map<Long, Double> map = new TreeMap<Long, Double>();
		String record;
		while ((record = bReader.readLine()) != null) {
			String[] temp = record.split(" ");
			if (temp.length == 3) {
				long accNo = Long.parseLong(temp[0]);
				String transactionType = temp[1];
				double amount = Double.parseDouble(temp[2]);
				boolean deposit = false;
				double balance = amount;
				if (!map.containsKey(accNo)
						&& (transactionType.equals("D") || transactionType
								.equals("d"))) {
					deposit = true;
				} else if ((transactionType.equals("D") || transactionType
						.equals("d"))) {
					balance = map.get(accNo);
					balance += amount;
					deposit = true;
				} else if ((transactionType.equals("W") || transactionType
						.equals("w"))) {
					if ((balance = map.get(accNo)) < amount) {
						throw new IllegalStateException(
								"Invalid operation ur balance is less than ur withdraw amount");
					} else {
						balance -= amount;
						deposit = true;
					}// else
				}// else if
	
				if (deposit) {
					map.put(accNo, balance);
				}
	
			}// if
		}// while
		return map;
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(
					args[0]));
			Map<Long, Double> map = new AccountDetails()
					.totalAmountDetails(bReader);
			System.out.println("A/C   Amount");
			System.out.println("----  -----");
			for (Map.Entry<Long, Double> entry : map.entrySet()) {
				Long key = entry.getKey();
				Double value = entry.getValue();
				System.out.println(key + "   " + value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

