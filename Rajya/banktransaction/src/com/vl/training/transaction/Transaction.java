package com.vl.training.transaction;
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

public final class Transaction {

    private Transaction() {
    }

    static Map processTransaction(final Scanner sc) {
        Map<String, Float> allTrans = new HashMap<String, Float>();
        while (sc.hasNext()) {
            String accId = sc.next();
            String mode = sc.next();
            Float amount = sc.nextFloat();
            Float value = allTrans.get(accId);
            if (value == null) {
                allTrans.put(accId, amount);
            } else {
                if (mode.equals("deposit")) {
                    Float sum = value + amount;
                    allTrans.put(accId, sum);
                }
                if (mode.equals("withdraw")) {
                    Float difference = value - amount;
                    allTrans.put(accId, difference);
                }
            }
        }
        return allTrans;
    }

    static void printResult(final Map allTrans) {
        System.out.println("AccNo  Amount");
        Set<Entry<String, Float>> entries = allTrans.entrySet();
        for (Entry<String, Float> ent : entries) {
            System.out.println(ent.getKey() + "    " + ent.getValue());
        }
    }

    public static void main(final String []args) throws FileNotFoundException {
        if (args.length == 1) {
            Scanner sc = new Scanner(new File(args[0]));
            Map m = processTransaction(sc);
            printResult(m);
        } else {
            System.out.println("Please provide one argument");
        }
    }
}
