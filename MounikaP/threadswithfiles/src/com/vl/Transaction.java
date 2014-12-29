package com.vl;
import java.util.Map.Entry;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
class Transaction {
    Map<String, Account> cusTransactionAmt = new HashMap<String, Account>();
    public Map customerDepositAndWithdrawl(final Scanner sc) {
        while (sc.hasNext()) {
            String cusId = sc.next();
            String status = sc.next();
            int amt = sc.nextInt();
            Account account = null;
            synchronized (cusTransactionAmt) {
                account = cusTransactionAmt.get(cusId);
                if (account == null) {
                    if (status.equals("D")) {
                        account = new Account(amt);
                    } else if (status.equals("W")) {
                        amt = 0 - amt;
                        account = new Account(amt);
                    }
                } else {
                    if (status.equals("D")) {
                        account.deposit(amt);
                    } else if (status.equals("W")) {
                        account.withdrawl(amt);
                    }
                }
                cusTransactionAmt.put(cusId, account);
            }
        }
        return cusTransactionAmt;
    }
}
