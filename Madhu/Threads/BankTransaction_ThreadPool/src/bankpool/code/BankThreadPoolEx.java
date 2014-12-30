package bankpool.code;
import java.io.File;
import java.io.FileNotFoundException;
public class BankThreadPoolEx {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2) {
            System.out.println(" please provide all the required input data ");
        } else {
            File directory = new File(args[0]);
            ThreadPool.startThreads(directory , args[1]);
            System.out.println("end of main");
        }
    }  
}


