package com.vl;
import java.io.FileNotFoundException;
import java.io.IOException;
class ReadProcessor extends Thread {
    FileReadWrite f;
    public ReadProcessor(FileReadWrite f) {
        this.f = f;
    }
    public void run() {
        try {
            f.readFile();
            //f.writeFile();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

