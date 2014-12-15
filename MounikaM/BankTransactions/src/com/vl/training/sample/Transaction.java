package com.vl.training.sample;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Transaction {
    public Map<String, Float> accountCalculation(Scanner sc) {
        Map<String, Float> hm = new HashMap<String, Float>();
        while (sc.hasNext()) {
            String accid = sc.next();
            String typeofTransaction = sc.next();
            Float money = sc.nextFloat();
            Float amount = hm.get(accid);

            if (amount == null) {
                if (typeofTransaction.equals("W")) {
                    System.out.println("There is No money to draw from " + accid + " Account");
                } else {
                    hm.put(accid, money);
                }
            } else {
                if (typeofTransaction.equals("D")) {
                    money = amount + money;
                    hm.put(accid, money);
                }
                if (typeofTransaction.equals("W")) {
                    if (money < amount) {
                        money = amount - money;
                        hm.put(accid, money);
                    } else {
                        System.out.println(" There is no sufficient money to withdrawl from " + accid + " Account");
                    }
                }
            }
        }
        return hm;
    }
    public static void main(String[] args) {
        Map<String, Float> hm;
        try {
            Scanner sc = new Scanner(new File(args[0]));
            if (args.length == 1) {
                Transaction t = new Transaction();
                hm = t.accountCalculation(sc);
                t.printHashMap(hm);
            } else {
                System.out.println("\n enter only one command line argument that is text file");
            }
        } catch (IOException io) {
            System.err.println(io);
        }
    }
    public void printHashMap(Map<String, Float> hm) {
        Set<String> keys = hm.keySet();
        for (String id : keys) {
            System.out.println("Coustomer accountid and amount is " + id + " " + hm.get(id));
        }
    }
}






