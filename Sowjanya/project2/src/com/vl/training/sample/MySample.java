package com.vl.training.sample;
import java.util.Scanner;
public class MySample {
    public static int countWords(String str) {
        int count=1,j=0;
        for(int i=0;i<=str.length()-1;i++) {
            
            if((str.charAt(i)==' ')) {
                count++;
                j=i;
           // System.out.println(count);
            while((str.charAt(j)==' '))
                j++;
            i=j-1;
            }
            
        }
        return count;
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter a sentence");        
        String sentence = in.nextLine();
        System.out.print("Your sentence has " + countWords(sentence) + " words.");
        //System.out.println("Hello, World!");
        /*Arg[0] is a number
        if (args.length != 1) {
            System.err.println("Invalid usage. Pass an integer parameter");
            return;
        }

         Convert the parameter to Integer
        int i;
        try {
            i = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.err.println("Invalid usage. Given parameter is not an integer");
            return;
        }
        MySample sample = new MySample();
        System.out.println("Double value of the given input is: " + sample.multTwo(i));
    }

    public int multTwo(final int i) {
        return 2 * i;
    }*/
  }
}
