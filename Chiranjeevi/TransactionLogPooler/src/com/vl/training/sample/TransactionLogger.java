package com.vl.training.sample;

import java.util.Scanner;
import java.util.Map;
import java.util.concurrent.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

class TransactionLogger extends Thread {

    public void processLog(final Scanner sc,
            final Hashtable<String, Account> log) {
        while (sc.hasNext()) {
            final String acc = sc.next();
            String remarks = sc.next();
            Long amount = sc.nextLong();
            System.out.println("In thread: " + Thread.currentThread().getId() + " Account : " + acc + " Amount : " + amount);
            //synchronizing on the Hashtable
            Account account = log.get(acc);
                if (account == null) {
                    if(remarks.equals("D")) {
                        synchronized(log) {
                            account = new Account(acc, amount);
                            log.put(acc, account);
                        }
                    }
                } else {
                    synchronized(account) {
                        if (remarks.equals("D")) {
                            account.deposit(amount);
                        } else if (remarks.equals("W")) {
                            account.withdraw(amount);
                        }
                        log.put(acc, account);
                    }

                }
        }
    }
}

class Account {

    String id;
    long amount;

    Account(String id, long amount) {
        this.id = id;
        this.amount = amount;
    }

    String getId() {
        return this.id;
    }

    long getAmount() {
        return this.amount;
    }

    void deposit(long amount) {
        this.amount = this.amount + amount;
    }

    void withdraw(long amount) {
        this.amount = this.amount - amount;
    }
}
