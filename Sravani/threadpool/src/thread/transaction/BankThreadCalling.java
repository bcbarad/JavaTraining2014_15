package thread.transaction;
import java.util.Scanner;
import java.io.FileNotFoundException;
class BankThreadCalling extends Thread {
    private Transaction t;
    private Scanner sc;
    BankThreadCalling(final Transaction t , final Scanner sc) {
        this.t = t;
        this.sc = sc;
    }
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" (Start) ");  
            t.transactionProcess(sc);  
            System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
