package com.vl.training.sample;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Transaction {
    static Map<String, CurrentBalance> hm = new HashMap<String, CurrentBalance>();
    public static  Map<String, CurrentBalance> amountCalculation(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(br);

            while (sc.hasNext()) {
                String accid = sc.next();
                String typeofTransaction = sc.next();
                String m = sc.next().trim();
                int money = Integer.parseInt(m);
                CurrentBalance amount = null;
                //CurrentBalance balance = null;
                amount = hm.get(accid);
                if(amount == null) {
                synchronized(hm) {
                    CurrentBalance balance = hm.get(accid);
                    if (balance == null) {
                        if (typeofTransaction.equals("W")) {
                            money = 0 - money;
                            System.out.println(accid);
                            System.out.println(money);
                            balance = new CurrentBalance(money);
                        } else {
                            if (typeofTransaction.equals("D")){
                                money = 0 + money;
                                System.out.println(accid);
                                System.out.println("1 a " + money);
                                balance = new CurrentBalance(money);
                            }
                        }
                        hm.put(accid, balance);
                        System.out.println(accid);
                        System.out.println(hm.get(accid).amount);
                        System.out.println("end of synchronization loop");
                    }
                    else {
                        System.out.println("HI");
                        updateAccount(money, balance, typeofTransaction);
                        System.out.println("Hellllo");
                        System.out.println(balance.amount);
                    }
                }

                }  else {
                     updateAccount(money,amount,typeofTransaction);
              }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    return hm;
    }
    public static void updateAccount (int money, CurrentBalance amount, String typeofTransaction ) {
        if (typeofTransaction.equals("W")) {
            System.out.println("hello");
            synchronized(amount) {
                amount.withdraw(money);
            }
        }
        if (typeofTransaction.equals("D")) {
            synchronized(amount) {
                //System.out.println("\n enetring into 4");
                amount.deposit(money);
            }
        }
    }


    public static void printAccountDetails() {
        Set<String> keys = hm.keySet();
        // System.out.println("hg");
        for (String k : keys) {
            //   System.out.println(k);
            // System.out.println(hm.get(k).amount);
            System.out.println("account number: " + k + " Available balance " +hm.get(k).amount);
        }
    }
}
public class TransactionsUsingThreads {
    public static void main(String[] args) {
        if(args.length >= 1) {
            //Transaction t = new Transaction();
            File directory = new File(args[0]);
            File[] listofFiles = directory.listFiles();
            int numofThreads = listofFiles.length;
            System.out.println(numofThreads);
            Thread[] thread = new Thread[numofThreads];
            for (int i = 0; i < numofThreads; i++) {
                thread[i] = new Thread(new ListOfFiles(listofFiles[i].getAbsolutePath()));
            }
            for (int i = 0; i < numofThreads; i++) {
                thread[i].start();
                System.out.println("thread" + i);
            }
            try {
                for (int i = 0; i < numofThreads; i++) {
                    //System.out.println("hellO");
                    thread[i].join();
                }
            } catch(Exception e) {
                System.err.println(e);
            }
            //System.out.println("hi");
            Transaction.printAccountDetails();
        } else {
            System.out.println("\n enter only one argument that is Directory");
        }
    }
}
class ListOfFiles implements Runnable {
    String fileName;
    Map<String, CurrentBalance> m;
    //Transaction t = new Transaction();
    public ListOfFiles(String fileName) {
        this.fileName = fileName;
    }
    public void run() {
        Transaction.amountCalculation(fileName);
    }
}

class CurrentBalance {
    int amount;
    public CurrentBalance(int amount) {
        this.amount = amount;
    }
    public void deposit(int money) {
        amount = amount + money;
    }
    public void withdraw(int money) {
        amount = amount - money;
    }
}


