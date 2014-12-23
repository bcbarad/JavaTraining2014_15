//package bank.code;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public final class BankThread {
    BankThread() {
    }
    
    
    public static void main(final String []args) throws FileNotFoundException {
        Hashtable bankdata = new Hashtable();
        if (args.length != 1) {
            System.out.println("please provide the required arguments ");
        } else {
            File directory = new File(args[0]);
            File[] fList = directory.listFiles();
            Thread[] threads = new Thread[fList.length];
            System.out.println(fList.length);
            BankTransaction  bankobj = new BankTransaction();
            for (int i=0 ; i < fList.length ;i++){
                Scanner sc = new Scanner(fList[i]);
                threads[i] = new BankTransactionThread(sc , bankobj , bankdata );
                threads[i].start();
                System.out.println("thread "+ i + " started ");        
            }
            for (int i=0 ; i < fList.length ;i++){
                 try {
                       threads[i].join();
                } catch(Exception e) {
                       e.printStackTrace();
                }
            }
        }
        //System.out.println("thread ");
        //BankTransaction b= new BankTransaction();
       // BankThread bt = new BankThread();
        BankThread.displayData(bankdata);
    }
    public static void displayData(final Hashtable bankdata) {
        Set<Map.Entry<Integer , Double>> set = bankdata.entrySet();
        System.out.println("print");
        for (Map.Entry<Integer , Double> bankm:set) {
            System.out.println(bankm.getKey() + " " + bankm.getValue());
        }
    }
}
class BankTransaction {
    BankTransaction() {
    }
    public synchronized  Hashtable checkTransactions(final Scanner sc) {
        Hashtable<Integer, Double> bankdata1 = new Hashtable<Integer , Double>();
        while (sc.hasNext()) {
            int customid = Integer.parseInt(sc.next());
            String transtype = sc.next();
            //System.out.println(transtype);
            double amount = Double.parseDouble(sc.next());
            Double totalamount = bankdata1.get(customid);
            if (totalamount == null) {
                bankdata1.put(customid , amount);
            } else {
                if (transtype.equals("withdraw")) {
                    Double remainingAmount = totalamount - amount;
                    bankdata1.put(customid , remainingAmount);
                } else if (transtype.equals("deposite")) {
                    Double total = amount + totalamount;
                    bankdata1.put(customid , total);
                }
            }
            //System.out.println(bankdata1.getKey() + " " + bankdata1.getValue());
            try {
                Thread.sleep(10);
            } catch(Exception e) {
                e.printStackTrace();
            }
          //return bankdata;
        }
        return bankdata1;
    }
    
}
class  BankTransactionThread  extends Thread {
    BankTransaction bankobj;// = new BankTransaction();
    Scanner sc;
    Hashtable<Integer, Double> bankdata1; //= new Hashtable<Integer , Double>();
    BankThread bt= new BankThread();
    BankTransactionThread(Scanner sc , BankTransaction bankobj , Hashtable bankdata) {
           this.bankobj = bankobj;
           //this.bankobj = new BankTransaction();
           this.bankdata1 = bankdata;
           this.sc = sc;
    }
    public void run() {
            System.out.println("thread running ");
            bankdata1 = bankobj.checkTransactions(sc);
            Set<Map.Entry<Integer , Double>> set = bankdata1.entrySet();
            for (Map.Entry<Integer , Double> bankm:set) {
                System.out.println(bankm.getKey() + " " + bankm.getValue());
            } 
            System.out.println("-----------");
            //bt.bankdata.putAll(bankdata1);
    }
}




























