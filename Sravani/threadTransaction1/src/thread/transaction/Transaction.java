package thread.transaction;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException;
import java.util.Map.Entry;
import java.util.Map;
class Transaction {
    private HashMap<String , Accounting> map = new HashMap<String , Accounting>();
    public void transactionProcess(final Scanner sc) throws FileNotFoundException {
        while (sc.hasNext()) {
            String accountId = sc.next();
            String code = sc.next();
            int amount = sc.nextInt();
            synchronized (map) {
                Accounting account = (Accounting) map.get(accountId);
                if (account == null) {
                    if (code.equals("w")) {
                        amount = 0 - amount;
                        account = new Accounting(amount , accountId);
                    } else if (code.equals("d")) {
                        account = new Accounting(amount , accountId);
                    }
                    map.put(accountId , account);
                } else {
                    if (code.equals("d")) {
                        account.deposit(amount);
                    } else if (code.equals("w")) {
                        account.withDrawl(amount);
                    }
                    map.put(accountId , account);
                }
            }
        }
    }
    public void display() {
        System.out.println("\n Account-id   Amount");
        Set<Map.Entry<String , Accounting>> set = map.entrySet();
        for (Map.Entry<String , Accounting> bankm:set) {
            Accounting acc = (Accounting) bankm.getValue();
            System.out.println(acc.getId() + "           " + acc.getAmount());
        }
    }
}
