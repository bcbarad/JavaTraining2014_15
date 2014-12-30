package com.vl.training.sample;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
final class DoTransaction {
    private DoTransaction() {
    }
    public static void doTransaction(final Scanner sc, final Map<String, Transaction> m) throws IOException {
        boolean temp = false;
        while (sc.hasNext()) {
            final String accountnumber = sc.next();
            String transtype = sc.next();
            double balance = sc.nextDouble();
            System.out.println(Thread.currentThread().getId());
            Transaction amount = null;
            synchronized (m) {
                amount = m.get(accountnumber);
                if (amount == null) {
                    if (transtype.equals("W")) {
                        //System.out.println("the new user trying to withdraw");
                        balance = 0 - balance;
                        amount = new Transaction(balance);
                    } else {
                        if (transtype.equals("D")) {
                        //System.out.println("the new user trying to deposite");
                            balance = 0 + balance;
                            amount = new Transaction(balance);
                        }
                    }
                    m.put(accountnumber, amount);
                    //System.out.println("end of synchronization loop");
                } else {
                    if (transtype.equals("W")) {
                        amount.withdraw(balance);
                    }
                    if (transtype.equals("D")) {
                        amount.deposit(balance);
                    }
                }
            }
        }
    }
}
