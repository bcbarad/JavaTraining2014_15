package thread.transaction;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.Set;
import java.io.FileNotFoundException;
class Transaction {
    synchronized void transactionProcess(Scanner sc) throws FileNotFoundException {
        HashMap<String , Integer> map = new HashMap<String , Integer>();
        while (sc.hasNext()) {
            String account = sc.next();
            String code = sc.next();
            Integer amount = sc.nextInt();
            Integer temp = map.get(account);
            if (temp == null) {
                map.put(account , amount);
            } else if (code.equals("d")) {
                map.put(account , (temp + amount));
            } else if (code.equals("w")) {
                map.put(account , (temp - amount));
            }
        }
        try {
            Thread.sleep(1000);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        Transaction.display(map);
    }
    public static void display(final HashMap<String , Integer> map) {
        Set set1 = map.entrySet();
        System.out.println(set1);
    }
}
class C extends Thread {
    Transaction t;
    Scanner sc;
    C(Transaction t , Scanner sc) {
        this.t = t;
        this.sc = sc;
    }
    public void run() {
        try {
            t.transactionProcess(sc);
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
public class ThreadTransaction {
    public static void main(String[] args) throws FileNotFoundException{
        File directory = new File("/home/sravani/JavaTraining2014_15/Sravani/threadTransaction/directory");
        File[] listOfFiles = directory.listFiles();
        C c1 = null;
        for(int i = 0; i < listOfFiles.length; i++) {
            Scanner sc = new Scanner(listOfFiles[i]);
            Transaction t = new Transaction();
            c1 = new C(t , sc);
            System.out.println("file name:" + listOfFiles[i].getName());
            c1.start();
            try {
                c1.join();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end of main");
    }
}
