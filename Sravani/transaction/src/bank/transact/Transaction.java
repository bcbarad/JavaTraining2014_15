package bank.transact;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.io.FileNotFoundException;
import java.io.File;
public final class Transaction {
    private Transaction() {
    }
    public static void main(final String[] args) {
        File file = new File(args[0]);
        try {
            Scanner sc = new Scanner(file);
            Transaction.transactionProcess(sc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void transactionProcess(final Scanner sc) {
        HashMap<String , Integer> set = new HashMap<String , Integer>();
        while (sc.hasNext()) {
            String account = sc.next();
            String code = sc.next();
            Integer amount = sc.nextInt();
            Integer temp = set.get(account);
            if (temp == null) {
                set.put(account , amount);
            } else if (code.equals("d")) {
                set.put(account , (temp + amount));
            } else if (code.equals("w")) {
                set.put(account , (temp - amount));
            }
        }
        Transaction.display(set);
    }
    public static void display(final HashMap<String , Integer> set) {
        Set set1 = set.entrySet();
        System.out.println(set1);
    }
}
