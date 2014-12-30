package thread.transaction;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class ThreadTransaction {
    public static void main(final String[] args) throws FileNotFoundException {
        File directory = new File(args[0]);
        File[] listOfFiles = directory.listFiles();
        Transaction t = new Transaction();
        BankThreadCalling tc = null;
        for (int i = 0; i < listOfFiles.length; i++) {
            Scanner sc = new Scanner(listOfFiles[i]);
            tc = new BankThreadCalling(t , sc);
            System.out.println("file name:" + listOfFiles[i].getName());
            tc.start();
        }
        for (int i = 0; i < listOfFiles.length; i++) {
            try {
                tc.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t.display();
        System.out.println("end of main");
    }
}
