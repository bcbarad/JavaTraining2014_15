package bankpool.code;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class ThreadPool {
    public static void startThreads(File  directory) throws FileNotFoundException  {
        ExecutorService executor = Executors.newFixedThreadPool(2);//creating a pool of 5 threads
        BankTransaction transobj = new BankTransaction();
        File[] listOfFiles = directory.listFiles();  
        for (int i = 0; i < listOfFiles.length; i++) { 
            Scanner sc = new Scanner(listOfFiles[i]); 
            Thread worker = new FileManager(transobj , sc);  
            executor.execute(worker);//calling execute method of ExecutorService  
        }  
        executor.shutdown();  
        while (!executor.isTerminated()) {   }  
        System.out.println("Finished all threads"); 
        transobj.displayFinalAccountSummary(); 
    }
}


