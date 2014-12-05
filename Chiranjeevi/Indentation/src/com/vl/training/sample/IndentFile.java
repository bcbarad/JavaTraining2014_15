package com.vl.training.sample;

import java.io.*;

public class IndentFile {

    static int indentate = 0;

    public static void main(String[] arr) throws IOException {
         if (arr.length != 1) {
            System.out.println("Input file should be specified");
            return;
         }
         FileReader fileReader = null;
         BufferedReader reader = null;
         //FileOutputStream fos = null;
         try {
             fileReader = new FileReader(arr[0]);
             reader = new BufferedReader(fileReader);
             String s="";
             while ((s =reader.readLine()) != null) {
                int i = 0;
                if (!s.isEmpty()) {
                    //line not empty
                    printSpaces(indentate);
                    while (s.charAt(i) == ' '){
                        //do nothing
                        i++;
                    }
                    for (; i < s.length(); i++){
                        if (s.charAt(i) == '{') {
                            indentate++;
                            System.out.println(s.charAt(i));
                            printSpaces(indentate);
                            continue;
                        }
                        if(s.charAt(i) == '}') {
                            indentate--;
                            System.out.println(s.charAt(i));
                            printSpaces(indentate);
                            continue;
                        }
                        System.out.print(s.charAt(i));
                    }
                    System.out.println();
                }
             }
         }
         catch (FileNotFoundException e) {
            e.printStackTrace();
         }
         catch (IOException e) {
             e.printStackTrace();
         }
         finally {
             try {
                 fileReader.close();
                 reader.close();
             }
             catch (IOException e) {
                 e.printStackTrace();
             }
         }
    }

public static void printSpaces(int indentate) {
        for (int i = 0; i < 4 * indentate; i++)
            System.out.print(" ");
        return;
    }
}
