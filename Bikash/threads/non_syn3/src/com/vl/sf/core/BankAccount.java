package com.vl.sf.core;

public class BankAccount {
	private int balance = 50;

	public int getBalance() {
		return balance;
	}
	public void withdraw(int amount){
		balance-=amount;
	}
}

