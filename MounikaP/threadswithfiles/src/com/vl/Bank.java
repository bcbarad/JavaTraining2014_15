package com.vl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.*;
class BankTransaction {
    Map<String, Integer> cusTransactionAmt = new HashMap<String, Integer>();
    public Map customerDepositAndWithdrawl(final Scanner sc) {
        //Map<String, Integer> cusTransactionAmt = new HashMap<String, Integer>();
        while (sc.hasNext()) {
            String cusId = sc.next();
            String status = sc.next();
            Integer amt = sc.nextInt();
            Integer totAmt = cusTransactionAmt.get(cusId);
            synchronized(cusId) {
                if (totAmt == null) {
                    cusTransactionAmt.put(cusId, amt);
                } else {
                    if (status.equals("D")) {
                        Integer preAmt = totAmt + amt;
                        cusTransactionAmt.put(cusId, preAmt);
                    } else if (status.equals("w")) {
                        Integer preAmt = totAmt - amt;
                        cusTransactionAmt.put(cusId, preAmt);
                    }
                }
            }
        }
        return cusTransactionAmt;

    }
    public void display() {
        Set<Entry<String, Integer>> cus = cusTransactionAmt.entrySet();
        System.out.println("cusID"   + "    " + "amount");
        System.out.println("-----------------------------");
        for (Entry<String, Integer> c : cus) {
            System.out.println(c.getKey() + "     " + c.getValue());
        }
        //System.out.println(cusTransactionAmt);
    }
}
class Processor extends Thread {
    private BankTransaction t;
    Scanner sc;
    public Processor(BankTransaction t, Scanner sc) {
        this.t = t;
        this.sc = sc;
    }
    public void run() {
        t.customerDepositAndWithdrawl(sc);
        //t.display();
    }
}
public class Bank extends Thread {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (args.length != 1) {
                Processor p = null;
                BankTransaction bt = new BankTransaction();
                File dir = new File(args[0]);
                File[] list = dir.listFiles();
                Thread[] threads = new Thread[list.length];
                for (int i = 0; i < list.length; i++) {
                    Scanner sc = new Scanner(list[i]);
                    System.out.println("file name:" + list[i].getName());
                    threads[i] = new Processor(bt, sc);
                    threads[i].start();
                    System.out.println("thread " + i +  "started");
                }
                for (int i = 0; i < list.length; i++) {
                    try {
                        threads[i].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                bt.display();
            }
            else {
                System.out.println("pass file as arguments");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}


