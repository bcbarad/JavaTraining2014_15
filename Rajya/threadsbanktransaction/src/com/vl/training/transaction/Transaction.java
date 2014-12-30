package com.vl.training.transaction;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Hashtable;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

class ProcessTransaction extends Thread {

    public void processLog(final Scanner sc,
            final Hashtable<String, Account> log) {
        while (sc.hasNext()) {
            String accNo = sc.next();
            String mode = sc.next();
            float amount = sc.nextFloat();
            Account account = log.get(accNo);
            //synchronizing on the Hashtable
            System.out.println("Entering for " + accNo + " " + Thread.currentThread().getName());
            if (account == null) {
                synchronized (log) {
                    if (log.get(accNo) == null) {
                        account = new Account(accNo, amount);
                        log.put(accNo, account);
                    }
                }
            } else {//synchronizing on the account 
                synchronized (account) {
                    if (mode.equals("deposit")) {
                        account.deposit(amount);
                    } else if (mode.equals("withdraw")) {
                        account.withdraw(amount);
                    }
                    log.put(accNo, account);
                }
            }
            System.out.println("Leaving for " + accNo + " " + Thread.currentThread().getName());
        }
    }
}

public final class Transaction {

    private ArrayList<Thread> al = new ArrayList<Thread>();
    private Hashtable<String, Account> allTrans = new Hashtable<String, Account>();
    private ProcessTransaction pt = new ProcessTransaction();

    public void getFiles(final String str) throws FileNotFoundException {
        File folder = new File(str);
        File[] noOfFiles  = folder.listFiles();
        if (noOfFiles != null) {
            for (File file : noOfFiles) {
                if (file.isDirectory()) {
                    getFiles(file.getName());
                } else {
                    final File f = file;
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                pt.processLog(new Scanner(f), allTrans);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    t.start();
                    al.add(t);
                }
            }
        }
    }

    void printResult() {
        System.out.println("--------------");
        System.out.println("AccNo  Amount");
        System.out.println("--------------");
        //getting value for the given key form hashmap
        Set<Entry<String, Account>> entries = allTrans.entrySet();
        for (Entry<String, Account> ent : entries) {
            Account ac = (Account) ent.getValue();
            System.out.println(ac.getId() + "    " + ac.getAmount());
        }
    }

    public void joinThreads() {
        for (Thread t : al) {
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(final String []args) throws FileNotFoundException {
        if (args.length == 1) {
            String folder = args[0];
            Transaction t = new Transaction();
            t.getFiles(folder);
            t.joinThreads();
            t.printResult();
        } else {
            System.out.println("Please provide one argument");
            return;
        }
    }
}
