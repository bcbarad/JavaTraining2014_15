package bankpool.code;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class FileManager extends Thread {
    BankTransaction transobj;
    Scanner sc;
    FileManager(BankTransaction transobj , Scanner sc) {
        this.transobj = transobj;
        this.sc = sc;
    }
    public void run() {      // run the threads
        try {
            System.out.println(Thread.currentThread().getName()+" (Start) ");  
            transobj.transactionProcess(sc);  
            System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
