package bank.code;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public final class BankTransaction {
    private BankTransaction() {
    }
    public static void main(final String []args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("please provide the required arguments ");
        } else {
            Scanner sc = new Scanner(new File(args[0]));
            Hashtable bankdata = BankTransaction.checkTransactions(sc);
            BankTransaction.displayData(bankdata);
        }
    }
    public static Hashtable checkTransactions(final Scanner sc) {
        Hashtable<Integer, Double> bankdata = new Hashtable<Integer , Double>();
        while (sc.hasNext()) {
            int customid = Integer.parseInt(sc.next());
            String transtype = sc.next();
            double amount = Double.parseDouble(sc.next());
            Double totalamount = bankdata.get(customid);
            if (totalamount == null) {
                bankdata.put(customid , amount);
            } else {
                if (transtype.equals("withdraw")) {
                    Double remainingAmount = totalamount - amount;
                    bankdata.put(customid , remainingAmount);
                } else if (transtype.equals("deposite")) {
                    Double total = amount + totalamount;
                    bankdata.put(customid , total);
                }
            }
        }
        return bankdata;
    }
    public static void displayData(final Hashtable bankdata) {
        Set<Map.Entry<Integer , Double>> set = bankdata.entrySet();
        for (Map.Entry<Integer , Double> bankm:set) {
            System.out.println(bankm.getKey() + " " + bankm.getValue());
        }
    }
}
