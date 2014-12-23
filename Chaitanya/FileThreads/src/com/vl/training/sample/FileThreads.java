package com.vl.training.sample;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
class FileRead {
    //Map m;
    public synchronized void accountDetails(File f, Map m) {
        try {
         //this.m = m;
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] total = str.split(" ");
                int curid = Integer.parseInt(total[0]);
                String type = total[1];
                int amount = Integer.parseInt(total[2]);
                boolean check = false;
                if (!m.containsKey(curid) && type.equals("D")) {
                    m.put(curid, amount);
                }
                else if (m.containsKey(curid)) {
                    int temp = (Integer) m.get(curid);
                    if ( type.equals("D")) {
                        amount = temp + amount;
                        check = true;
                    } else if (type.equals("W")) {
                        amount = temp - amount;
                        if (amount < 0) {
                            check = false;
                            System.out.println("No sufficient funds");
                         } else {
                             check = true;
                         }
                    } else {
                        System.out.println("No sufficient Funds");
                    }   
                    if (check) {
                        m.put(curid, amount);
                    }
                }
                else {
                    System.out.println("cannot find a value");
                } 
            }
            display(m);
            //return m;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    final void display(final Map m) {
        Set<Integer> keys = m.keySet();
        for (Integer i : keys) {
            System.out.println("id of customer " + i
                + " has amount " + m.get(i));
        }
    }
}
class ThreadFile extends Thread {
    File f;
    FileRead fr;
    Map m;
    ThreadFile(File f, FileRead fr,Map m) {
        this.f = f;
        this.fr = fr;
        this.m = m;
       // Thread t1 = new Thread();
    }
    public void run() {
        fr.accountDetails(f,m);
    }
}
public class FileThreads {
    public static void main(String[] args) {
        Map m = new HashMap();
        FileRead fr = new FileRead();
        FileThreads ft = new FileThreads();
        File[] f = ft.getNumberOfFiles(args[0]);
        ThreadFile[] tf = new ThreadFile[f.length];
        for (int i = 0; i <f.length; i++) {
            tf[i] = new ThreadFile(f[i], fr,m);
            tf[i].start();
        }
        //fr.display();
    }
    public File[] getNumberOfFiles(String dirpath) {
        File f = new File(dirpath);
        File[] files = f.listFiles();
        return files;
    }
}
