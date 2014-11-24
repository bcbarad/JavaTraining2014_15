package com.vl.training.sample;
import java.util.Scanner;
public class MySample {
    public static int parenthesis(final String str) {
        int count = 0;
        for (int i = 0; i <= str.length() - 1 && count >= 0; i++) {
            // while(str.charAt(i)!='\0')
            //System.out.println(str[i]);
            if (str.charAt(i) == '(') {
                count++;
            }
            if (str.charAt(i) == ')') {
                count--;
            }
            //i++;
        }
        if (count == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        System.out.print("in your expression" + parenthesis(sentence));
    }
}
