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
            t.transactionProcess(sc);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
