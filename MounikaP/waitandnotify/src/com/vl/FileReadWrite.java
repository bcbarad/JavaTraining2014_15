package com.vl;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
class FileReadWrite {
    ReadWriteLock rw = new ReadWriteLock();
    FileReader fr = null;
    FileWriter fw = null;
    File file;
    public FileReadWrite(File file) {
        this.file = file;
    }
    public void readFile() throws InterruptedException, IOException, FileNotFoundException {
        try {
            rw.readLock();
            String line;
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } finally {
            rw.releaseReadLock();
        }
    }
    public void writeFile() throws InterruptedException, IOException, FileNotFoundException {
        try {
            rw.writeLock();
            //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            String content = "Hello";
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.append(content);
            //out.println("hello");
            bw.close();
        } finally {
            rw.releaseWriteLock();
        }
    }
}
