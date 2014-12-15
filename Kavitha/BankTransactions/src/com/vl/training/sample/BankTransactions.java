package com.vl.training.sample;
import java.util.*;
import java.io.*;
import java.lang.NullPointerException;

public class BankTransactions {
    public static void main(final String []args) throws FileNotFoundException {
        if (args.length > 0) {
            Scanner sc = new Scanner(new File(args[0]));
            Map m = getAmount(sc);
            displayAmount(m);
        } else {
            System.out.println("Please attach input file");
        }
    }
    public static Map getAmount(final Scanner sc) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        try {
            while (sc.hasNext()) {
                String accNo = sc.next();
                String transType = sc.next();
                Integer amount = sc.nextInt();
                Integer total = m.get(accNo);
                if (total == null) {
                    m.put(accNo, amount);
                } else {
                    if (transType.equals("WD")) {
                        Integer remainingAmount = total - amount;
                        m.put(accNo, remainingAmount);
                    }
                    if (transType.equals("D")) {
                        Integer totalAmount = amount + total;
                        m.put(accNo, totalAmount);
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return m;
    }
    public static void displayAmount(final Map m) {
        Set<Map.Entry<String, Integer>> s = m.entrySet();
        System.out.println("AccNo  Amount");
        for (Map.Entry<String, Integer> mtr:s) {
            System.out.println(mtr.getKey() + "     " + mtr.getValue());
        }
    }
}
