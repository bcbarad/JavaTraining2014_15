package com.vl.training.sample;
import java.io.IOException;
import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
public class Transaction {
    public static void main(final String[] args) {
        try {
            if (args.length > 0) {
                Transaction t = new Transaction();
                t.accountDetails(args[0]);
            } else {
                System.out.println("enter two files as input");
            }
        } catch (Exception io) {
            io.printStackTrace();
        }
    }
    final void accountDetails(final String args) throws IOException {
        Scanner sc = new Scanner(new File(args));
        Map m = new HashMap();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] total = str.split(" ");
            if (total.length > 2) {
                int curid = Integer.parseInt(total[0]);
                String type = total[1];
                int amount = Integer.parseInt(total[2]);
                //Insert i = new Insert(curid,amount);
                if (!m.containsKey(curid) && type.equals("D")) {
                   // System.out.println("hello");
                    m.put(curid, amount);
                } else if (m.containsKey(curid) && type.equals("D")) {
                    int temp = (Integer) m.get(curid);
                    amount = temp + amount;
                    //System.out.println(amount);
                    m.put(curid, amount);
                } else if (m.containsKey(curid) && type.equals("W")) {
                    int temp = (Integer) m.get(curid);
                    amount = temp - amount;
                    if (amount < 0) {
                        System.out.println("No sufficient funds");
                    } else {
                        m.put(curid, amount);
                        //System.out.println(amount);
                    }
                } else {
                    System.out.println("No sufficient Funds");
                }
               // System.out.println(m);
            } else {
                System.out.println("cannot find a value");
            }
        }
        display(m);
    }
    final void display(final Map m) {
        Set<Integer> keys = m.keySet();
        for (Integer i : keys) {
            System.out.println("id of customer " + i
                + " has amount " + m.get(i));
        }
    }
   /* public int hashCode() {
        System.out.println("hello");
        return 1;
    }*/
}

/*class Insert {
    int curid,amount;
    Insert(int curid, int amount) {
        this.curid = curid;
        this.amount = amount;
    }
    public boolean equals(Object o) {
        if (o instanceof Insert) {
            Insert k = (Insert) o;
            if (this.curid == k.curid) {
                k.amount = this.amount+ k.amount;
                return true;
            }
        }
            return false;
    }
    public int hashCode() {
        return curid;
    }
}*/
