package com.vl.training.sample;
import java.util.Map;

public class ListOfFiles implements Runnable {
    String fileName;
    Map<String, CurrentBalance> m;
    public ListOfFiles(String fileName) {
        this.fileName = fileName;
    }
    public void run() {
        m = Transaction.amountCalculation(fileName);
    }
}
