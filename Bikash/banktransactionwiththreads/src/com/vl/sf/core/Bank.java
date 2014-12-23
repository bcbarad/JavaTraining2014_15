package com.vl.sf.core;

public class Bank {
	
	protected double amount = 0;

	public double getAmount() {
		return amount;
	}

	public boolean deposit(double amount) {
		if (amount != 0) {
			this.amount += amount;
			return true;
		} else {
			return false;
		}
	}

	public boolean withdraw(double amount) {
		if (this.amount >= amount) {
			this.amount -= amount;
			return true;
		} else {
			return false;
		}

	}

}

