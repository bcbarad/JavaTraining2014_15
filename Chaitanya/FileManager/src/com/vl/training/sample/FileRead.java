package com.vl.training.sample;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
class FileRead {
    public void accountDetails(final File f, final Map m) {
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] total = str.split(" ");
                String curid = total[0];
                String type = total[1];
                int amount = (Integer.parseInt(total[2]));
                Account account = (Account) m.get(curid);
                if (account == null) {
                    synchronized (m) {
                        if (type.equals("D") || type.equals("d")) {
                            account = new Account(curid, amount);
                        } else {
                            amount = 0 - amount;
                            account = new Account(curid, amount);
                        }
                        m.put(curid, account);
                    }
                } else {
                    synchronized (account) {
                        if (type.equals("D")) {
                            account.deposit(amount);
                        } else {
                            account.withdraw(amount);
                        }
                        m.put(curid, account);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    final void display(final Map m) {
        Set<String> keys = m.keySet();
        for (String i : keys) {
            Account account = (Account) m.get(i);
            System.out.println("id of customer " + i
                + " has amount " + account.amount);
        }
    }
}
