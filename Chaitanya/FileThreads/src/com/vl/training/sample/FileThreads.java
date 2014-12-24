package com.vl.training.sample;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
public class FileThreads {
    public static void main(final String[] args) {
        Map m = new HashMap();
        FileRead fr = new FileRead();
        FileThreads ft = new FileThreads();
        File[] f = ft.getNumberOfFiles(args[0]);
        ThreadFile[] tf = new ThreadFile[f.length];
        for (int i = 0; i < f.length; i++) {
            //System.out.println(i);
            tf[i] = new ThreadFile(f[i], fr, m);
            tf[i].start();
        }
        try {
            for (int i = 0; i < f.length; i++) {
                tf[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fr.display(m);
    }
    public final File[] getNumberOfFiles(final String dirpath) {
        File f = new File(dirpath);
        File[] files = f.listFiles();
        //System.out.println(files.length);
        return files;
    }
}
