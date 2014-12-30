package com.vl.training.sample;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
class ThreadTransactions extends Thread {
    private static Map<String, Transaction> m = new HashMap<String, Transaction>();
    private Scanner sc;
    private String name;
    ThreadTransactions(final Scanner scan) {
        this.sc = scan;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            DoTransaction.doTransaction(sc , m);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(Thread.currentThread().getName() + " End.");
    }
    static void printDetails() {
        System.out.println("account details after doing transaction");
        System.out.println("AccNo \t Amount");
        Set<Entry<String, Transaction>> entries = m.entrySet();
        for (Entry<String, Transaction> ent : entries) {
            System.out.println(ent.getKey() + "\t" + ent.getValue().amount);
        }
    }
}
