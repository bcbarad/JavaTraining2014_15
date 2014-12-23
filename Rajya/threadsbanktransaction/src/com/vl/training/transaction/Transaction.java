package com.vl.training.transaction;
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

class ProcessTransaction extends Thread {

    private Scanner sc;
    private static Map<String, Float> allTransactions = new HashMap<String, Float>();

    ProcessTransaction(final File file) throws FileNotFoundException {
        sc = new Scanner(file);
    }

    public void run() {
        Map<String, Float> m = ProcessTransaction.processlog(sc, allTransactions);
        ProcessTransaction.printResult();
    }

    public static synchronized Map processlog(final Scanner sc, final Map<String, Float> allTrans) {
        //reading values from a file
        while (sc.hasNext()) {
            String accId = sc.next();
            String mode = sc.next();
            Float amount = sc.nextFloat();
            Float value = allTrans.get(accId);
            if (value == null) {
                allTrans.put(accId, amount);
            } else {
                if (mode.equals("deposit")) {
                    amount = value + amount;
                }
                if (mode.equals("withdraw")) {
                    amount = value - amount;
                }
                //add key-value pairs to hashmap
                allTrans.put(accId, amount);
            }
        }
        return allTrans;
    }

    static void printResult() {
        System.out.println("--------------");
        System.out.println("AccNo  Amount");
        System.out.println("--------------");
        //getting value for the given key form hashmap
        Set<Entry<String, Float>> entries = allTransactions.entrySet();
        for (Entry<String, Float> ent : entries) {
            System.out.println(ent.getKey() + "    " + ent.getValue());
        }
    }
}

public final class Transaction {

    private Transaction() {
    }

    public void getFiles(final String str) throws FileNotFoundException {
        File folder = new File(str);
        File[] noOfFiles  = folder.listFiles();
        if (noOfFiles != null) {
            for (File file : noOfFiles) {
                if (file.isDirectory()) {
                    getFiles(file.getName());
                } else {
                    System.out.println("File name:" + file.getName());
                    ProcessTransaction pt = new ProcessTransaction(file);
                    pt.start();
                    try {
                        pt.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(final String []args) throws FileNotFoundException {
        if (args.length == 1) {
            String folder = args[0];
            Transaction t = new Transaction();
            t.getFiles(folder);
        } else {
            System.out.println("Please provide one argument");
        }
    }
}
