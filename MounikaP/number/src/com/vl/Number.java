package com.vl;
import java.util.Scanner;
public final class Number {
   private Number() {
}
   public static void main(final String[] args) {
       String[] ones = {"one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
       String[] tens = {"ten" , "twenty" , "thirty" , "fourty" , "fifty" , "sixty" , "seventy" , "eighty" , "ninety"};
       String[] digits = {"eleven" , "twelve" , "thirteen" , "fourteen" , "fifteen" , "sixteen" , "seventeen" , "eighteen" , "ninteen"};
       Scanner sc = new Scanner(System.in);
       System.out.println("enter a number");
       int n = sc.nextInt();
       Test t = new Test();
       t.words(n, ones, tens, digits);
       }   
   }
class Test {
   protected Test() {
   }
  static void words(final int num , final String[] ones , final String[] tens , final String[] digits) {
       int temp = 0 , i = 0 , n = num;
       if (n == 0) {
           System.out.println("zero");
       }
       if ( n < 0 ) {
           n = n * -1;
           System.out.println("n");
           } 
       if ((n > 1000) && (n < 99999)) {
           temp = n / 1000;
           n = n % 1000;
           System.out.println(ones[temp - 1]);
           System.out.println("thousand");
       }  
       if (n > 100) {
           temp = n / 100;
           n = n % 100;
           System.out.println(ones[temp - 1]);
           System.out.println("hundred and");
       }
       if (( n > 10) && (n < 20)) {
           temp = n / 10;
           System.out.println(tens[temp - 1]);
       }
       if ((n >= 20) && (n <= 99)) {
           temp = n / 10;
           n = n % 10;
           System.out.println(tens[temp - 1]);
       } 
       if (n < 10) {
           System.out.println(ones[n - 1]);
       }
   }
}

   

  

   
   
