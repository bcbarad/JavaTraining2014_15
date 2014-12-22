package com.vl.sf.core;

public class BalanceCheck implements Runnable {
	BankAccount bacc = new BankAccount();

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			makeWithdrawal(10);
			if (bacc.getBalance() < 0) {
				System.out.println("Account is overdrawn");
			}
		}
	}

	private void makeWithdrawal(int amount) {
		if (bacc.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName()
					+ " is going to withdraw");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			bacc.withdraw(amount);
			System.out.println(Thread.currentThread().getName()+" complete the withdraw");
		}else {
			System.out.println("Not enough in account for "+Thread.currentThread().getName()+" to withdraw "+bacc.getBalance());
		}
	}

	public static void main(String[] args) {
		BalanceCheck bc=new BalanceCheck();
		Thread th1=new Thread(bc);
		Thread th2=new Thread(bc);
		th1.setName("Bikash");
		th2.setName("Ashok");
		th1.start();
		th2.start();
		try {
            Thread.sleep(1000);
        } catch(Exception e) {
            e.printStackTrace();
        }
	}

}

