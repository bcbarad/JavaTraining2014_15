package thread.transaction;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.Set;
import java.io.FileNotFoundException;
class Transaction {
    HashMap<String , Integer> map = new HashMap<String , Integer>();
    public void transactionProcess(Scanner sc) throws FileNotFoundException {
        //HashMap<String , Integer> map = new HashMap<String , Integer>();
        while (sc.hasNext()) {
            String account = sc.next();
            String code = sc.next();
            Integer amount = sc.nextInt();
            Integer temp = map.get(account);
            synchronized(account) {
                if (temp == null) {
                    map.put(account , amount);
                } else if (code.equals("d")) {
                    map.put(account , (temp + amount));
                } else if (code.equals("w")) {
                    map.put(account , (temp - amount));
                }
            }
        }
        try {
            Thread.sleep(1000);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public void display() {
        //Set set1 = map.entrySet();
        System.out.println(map);
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
        File directory = new File(args[0]);
        File[] listOfFiles = directory.listFiles();
        Transaction t = new Transaction();
        C c1 = null;
        for(int i = 0; i < listOfFiles.length; i++) {
            Scanner sc = new Scanner(listOfFiles[i]);
            //Transaction t = new Transaction();
            c1 = new C(t , sc);
            System.out.println("file name:" + listOfFiles[i].getName());
            c1.start();
        }
        for (int i=0; i < listOfFiles.length; i++) {
            try {
                c1.join();
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        t.display();
        System.out.println("end of main");
    }
}
