package bankpool.code;
import java.io.File;
import java.io.FileNotFoundException;
public class BankThreadPoolEx {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(args[0]);
        ThreadPool.startThreads(directory);
        System.out.println("end of main");
    }  
}


