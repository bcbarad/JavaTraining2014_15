package com.vl.training.sample;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Hashtable;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;


public class BankTransactions {
    Hashtable<String, BankAccount> hashtable = new Hashtable<String, BankAccount>();
    public ArrayList<Thread> tList = new ArrayList<Thread>();
    private File f;
    private Scanner sc;
    public void calculateAmount(final File f, final Hashtable<String, BankAccount> m) {
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String accNo = sc.next();
                String transType = sc.next();
                double  amount = sc.nextInt();
                BankAccount account = m.get(accNo);
                if (account == null) {
                    synchronized (hashtable) {
                        account = hashtable.get(accNo);
                        if (account == null) {
                            account = new BankAccount(accNo, amount);
                            if (transType.equals("D")) {
                                account.deposit(amount);
                                hashtable.put(accNo, account);
                            }
                        }
                    }
                } else {
                    synchronized (account) {
                        if (transType.equals("D")) {
                            account.deposit(amount);
                        } else {
                            if (transType.equals("WD")) {
                                account.withdraw(amount);
                            }
                        }
                        hashtable.put(accNo, account);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processFiles(final File file) {
        final File []files;
        files = file.listFiles();
        for (final File f:files) {
            if (f.isDirectory()) {
                processFiles(f);
            } else {
                final File temp = f;
                System.out.println("Processing file : " +f.getName());
                Thread thread = new Thread(new Runnable() {
                        public void run() {
                        calculateAmount(temp, hashtable);
                        }
                });
                thread.start();
                tList.add(thread);
            }
        }
    }
    public void displayAmount() {
        Set<Map.Entry<String, BankAccount>> s = hashtable.entrySet();
        System.out.println("AccNo Amount");
        for (Map.Entry<String, BankAccount> mtr:s) {
            BankAccount account = (BankAccount) mtr.getValue();
            System.out.println(mtr.getKey() + " " + account.getValue());
        }
    }
    public static void main(final String []args) throws FileNotFoundException {
        if (args.length > 0) {
            File f = new File(args[0]);
            BankTransactions bt = new BankTransactions();
            bt.processFiles(f);
            bt.joinThreads();
            bt.displayAmount();
        } else {
            System.out.println("Please attach input file");
        }
    }
    public void joinThreads() {
        for (Thread t : tList) {
            try {
                t.join();                    } catch(Exception e) {
                    e.printStackTrace();
                }
        }
    }
}

