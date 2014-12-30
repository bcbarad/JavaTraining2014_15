package bank.code;
import java.util.Scanner;
import java.io.FileNotFoundException;
class BankTransactionThread extends Thread {
    BankTransactionProcess transobj;
    Scanner sc;
    BankTransactionThread(BankTransactionProcess transobj , Scanner sc) {
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
