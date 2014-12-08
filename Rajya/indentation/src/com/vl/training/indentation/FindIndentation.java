package com.vl.training.indentation;
import java.io.*;

public class FindIndentation {
    public static void main(final String []args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            String data;
            int depth = 0;
            while ((data = br.readLine()) != null) {
                for (int i = 0; i < data.length(); i++) {
                    if (data.charAt(i) == '{') {
                        depth = depth + 4;
                        System.out.println(" " + data.charAt(i));
                        printSpace(depth);
                        continue;
                    }
                    if (data.charAt(i) == '}') {
                        depth = depth - 4;
                        System.out.println();
                        printSpace(depth);
                        System.out.print(data.charAt(i));
                        continue;
                    }
                    if (data.charAt(i) == ';') {
                        System.out.println(data.charAt(i));
                        printSpace(depth);
                        continue;
                    }
                    System.out.print(data.charAt(i));
                }
            }
           
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        finally {
            br.close();
        }
    }

    static void printSpace(int depth) {
        for (int j = 0; j < depth; j++) {
            System.out.print(" ");
        }
    }
}
