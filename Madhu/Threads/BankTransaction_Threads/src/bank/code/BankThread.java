package bank.code;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Map;
import java.io.FileNotFoundException;
class BankTransaction {
    Hashtable<Integer , Double> bankdata = new Hashtable<Integer , Double>();
    public void transactionProcess(Scanner sc) throws FileNotFoundException {
        while (sc.hasNext()) {
            Integer customid = sc.nextInt();
            String transtype = sc.next();
            double amount = Double.parseDouble(sc.next());
            Double totalamount = bankdata.get(customid);
            synchronized(customid) {
                if (totalamount == null) {
                    if (transtype.equals("withdraw")) {   //check that is the initial transaction be withdraw, id yes then amount should be negative
                        amount = 0 - amount;
                    }
                    bankdata.put(customid , amount);
                } else if (transtype.equals("deposite")) {                 // this check and adds the amount to accountid
                    bankdata.put(customid , (totalamount + amount));
                } else if (transtype.equals("withdraw")) {                // this check and subtracts the amount from account id
                    bankdata.put(customid , (totalamount - amount));
                }
            }
        }
    }
    public void displayFinalAccountSummary() {       // this method displays the final amount of all accounts after completion of the all files
        Set<Map.Entry<Integer , Double>> set= bankdata.entrySet();
        System.out.println("\n Account-id   Amount");
        for(Map.Entry<Integer , Double> bankm:set){
            System.out.println(bankm.getKey()+"           "+bankm.getValue());
        }
    }
}
class BankTransactionThread extends Thread {
    BankTransaction transobj;
    Scanner sc;
    BankTransactionThread(BankTransaction transobj , Scanner sc) {
        this.transobj = transobj;
        this.sc = sc;
    }
    public void run() {      // run the threads
        try {
            transobj.transactionProcess(sc);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
public class BankThread {
    public static void main(String[] args) throws FileNotFoundException{
        File directory = new File(args[0]);
        File[] listOfFiles = directory.listFiles();
        BankTransaction transobj = new BankTransaction();
        Thread[] threads = new Thread[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {                // loop can creates an array  of threads and starts those threads
            Scanner sc = new Scanner(listOfFiles[i]);
            threads[i] = new BankTransactionThread(transobj , sc);
            threads[i].start();
            System.out.println("thread "+ threads[i].getId() +" started");
        }
        for (int i=0; i < listOfFiles.length; i++) {                // this loop can join the threads , then the main thread waits until all child threads all complete
            try {
                threads[i].join();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        transobj.displayFinalAccountSummary ();
        System.out.println("end of main");
    }
}
