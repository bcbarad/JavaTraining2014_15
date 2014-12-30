package thread.transaction;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.FileNotFoundException;
public class ThreadPoolTransaction {
    public static void main(String[] args) throws FileNotFoundException {
       if (args.length != 2) {
            System.out.println(" please provide all the required input data ");
        } else {
            File directory = new File(args[0]);
            ThreadPool.runThread(directory , args[1]);
            System.out.println("end of main");
        }
    }
}
