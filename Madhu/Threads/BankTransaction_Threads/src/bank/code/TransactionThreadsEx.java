package bank.code;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class TransactionThreadsEx {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println(" Please provide the required arguments ");
        } else {
            File directory = new File(args[0]);
            File[] listOfFiles = directory.listFiles();
            BankTransactionProcess transobj = new BankTransactionProcess();
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
}


