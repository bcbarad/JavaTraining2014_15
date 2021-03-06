package com.vl.training.sample;
//import java.util.Scanner;
public final class IntString {
    private IntString() {
    }
    static String[] thousands = new String[]{"one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
    static String[] teens = new String[]{"eleven" , "twelve" , "thirteen" , "fourteen" , "fifteen" , "sixteen" , "sventeen" , "eighteen" , "ninteen"};
    static String[] tenvalue = new String[]{"ten" , "twenty" , "thirty" , "fourty" , "fifty" , "sixty" , "sventy" , "eighty" , "ninty"};
    static int tvalue = 0 , hvalue = 0 , tensvalue = 0 , temp = 0;
    static String output = " ";
    public static void main(final String[] args) {
        int number = Integer.parseInt(args[0]);
        String s = new Integer(number).toString();
        int len = s.length();
        String result = IntString.intstring(number);
        System.out.println(result);
    }
    public static String intstring(int number) {
        String s = new Integer(number).toString();
        int len = s.length();
        if (len > 0 && len <= 4) { 
            for (int i = 0; i < len; i++) {
                String a = new Integer(number).toString();
                int length = a.length();
                if (length == 4) {
                    tvalue = number / 1000;
                    number = number % 1000;
                    //output = thousands[tvalue - 1] + " thousand ";
                } else if (length == 3) {
                      hvalue = number /100;
                      number = number %100;
                   // output+ = thousands[hvalue - 1] + " hundred and ";
                  } else if (length == 2) {
                      if ((number % 10) == 0) {
                          tensvalue = (number / 10);
                      }
                      else {
                          temp = (number / 10);
                          number = number % 10;
                          // output+ = tenvalue[temp - 1] + " " +thousands[number - 1];
                      }
                    } else{
                 }   
                 /*  return thousands[tvalue-1] + " thousand " + thousands[hvalue-1] + " hundred and " + tenvalue[temp-1] + " " + thousands[number-1];*/
            }
        }  
        return thousands[tvalue - 1] + " thousand " + thousands[hvalue - 1] + " hundred and " + tenvalue[temp - 1] + " " + thousands[number - 1];
    }

}
