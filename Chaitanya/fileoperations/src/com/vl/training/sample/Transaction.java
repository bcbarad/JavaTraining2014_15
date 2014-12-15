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
                boolean check = false;
                if (!m.containsKey(curid) && type.equals("D")) {
                     check = true;
                }
                else if (m.containsKey(curid)) {
                    int temp = (Integer) m.get(curid);
                    if ( type.equals("D")) {
                        amount = temp + amount;
                        check = true;
                    } else if (type.equals("W")) {
                        amount = temp - amount;
                        if (amount < 0) {
                            check = false;
                            System.out.println("No sufficient funds");
                        } else {
                           check = true;
                        }
                    } else {
                        System.out.println("No sufficient Funds");
                    }
                }
                if (check) {
                    m.put(curid, amount);
                }
             }
             else {
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
        //System.out.println("hello");
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
