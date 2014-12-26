package com.vl.training.sample;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Transaction {
    static Map<String, CurrentBalance> hm = new HashMap<String, CurrentBalance>();
    public static Map<String, CurrentBalance> amountCalculation(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);
            while (sc.hasNext()) {
                String accid = sc.next();
                String typeofTransaction = sc.next();
                String m = sc.next();
                int money = Integer.parseInt(m);
                CurrentBalance amount = null;
                amount = hm.get(accid);
                if (amount == null) {
                    synchronized (hm) {
                        amount = hm.get(accid);
                        if (amount == null) {
                            if (typeofTransaction.equals("W")) {
                                System.out.println("enetring this loop when amonut is null and transaction type is withdraw");
                                money = 0 - money;
                                //System.out.println(accid);
                                //System.out.println(money);
                                amount = new CurrentBalance(money);
                            } else {
                                if (typeofTransaction.equals("D")) {
                                    System.out.println("enetring this loop ehen amonut is null and transaction type is deposit");
                                    money = 0 + money;
                                    //System.out.println(accid);
                                    //System.out.println(money);
                                    amount = new CurrentBalance(money);
                                }
                            }
                            hm.put(accid, amount);
                            System.out.println(accid);
                            System.out.println(Thread.currentThread());
                            //System.out.println(hm.get(accid).amount);
                            System.out.println("end of synchronization loop");
                        } else {
                            System.out.println(Thread.currentThread());
                            updateAccount(money, amount, typeofTransaction);
                            System.out.println(amount.amount);
                        }
                    }
                } else {
                    updateAccount(money, amount, typeofTransaction);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return hm;
    }
    public static void updateAccount(int money, CurrentBalance amount, String typeofTransaction) {
        if (typeofTransaction.equals("W")) {
            synchronized (amount) {
                amount.withdraw(money);
            }
        }
        if (typeofTransaction.equals("D")) {
            synchronized (amount) {
                amount.deposit(money);
            }
        }
    }
    public static void printAccountDetails() {
        Set<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("account number: " + k + " Available balance " + hm.get(k).amount);
        }
    }
}
