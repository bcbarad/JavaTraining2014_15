package com.vl.training.sample;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
class ThreadTransaction extends Thread {
    private static Map<String, Transaction> m = new HashMap<String, Transaction>();
    private Scanner sc;
    private String name;
    ThreadTransaction(final Scanner scan) {
        this.sc = scan;
    }
    //to print currently executing thread name
    public void printMsg() {
        Thread thread = Thread.currentThread();
        name = thread.getName();
        //System.out.println("name=" + name);
        System.out.println("Thread :" + name + "started");
    }
    //thread starts from here
    public void run() {
        printMsg();
        try {
            DoTransaction.doTransaction(sc , m);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread :" + name + "ended");
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
