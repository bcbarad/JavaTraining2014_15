package com.vl.training.sample;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
final class Transactions {
    private Transactions() {
    }
    public static void main(final String[] args) {
        if (0 < args.length) {
            File inFile = new File(args[0]);
            Transactions trans = new Transactions();
            try {
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(inFile));
                trans.processingDetails(br);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("no files to read");
        }
    }
    public static void processingDetails(final BufferedReader br) throws IOException {
        String sCurrentLine = " ";
        Map<String, Float> m = new HashMap<String, Float>();
        while ((sCurrentLine = br.readLine()) != null) {
            String[] field = sCurrentLine.split("\t");
            String accountnumber = field[0];
            String transtype = field[1];
            Float balance = Float.parseFloat(field[2]);
            Float amount = m.get(accountnumber);
            if (amount == null) {
                m.put(accountnumber , balance);
            } else {
                if (transtype.equals("D")) {
                    float sum = amount + balance;
                    m.put(accountnumber , sum);
                }
                if (transtype.equals("W")) {
                    float sum = amount - balance;
                    m.put(accountnumber , sum);
                }
            }
        }
        printDetails(m);
    }
    static void printDetails(final Map m) {
        System.out.println("AccNo  Amount");
        Set<Entry<String, Float>> entries = m.entrySet();
        for (Entry<String, Float> ent : entries) {
            System.out.println(ent.getKey() + "    " + ent.getValue());
        }
    }
}
