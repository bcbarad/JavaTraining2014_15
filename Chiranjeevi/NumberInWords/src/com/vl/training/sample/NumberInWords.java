package com.vl.training.sample;

public class NumberInWords {
    public static int pos;
    public static void main(String[] arr) {
        if (arr.length == 1) {
            int n = Integer.parseInt(arr[0]);
            if (n == 0){
                System.out.println("Zero");
            }
            else if (n > 0 ) {
                toWords(n);
                System.out.println();
            }
            else {
                System.out.println("Please enter a positive integer");
            }
        }
        else {
            System.out.println("Pass Exactly one number");
        }
    }
    public static void toWords(int n) {
        String[] ones = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tens = {"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty"};
        String[] spl = {"","hundred","thousand","lakh","crore"};
                
        if(n < 20) {
            System.out.print(ones[n % 20]+" ");
        }
        else if (n < 100) {
           System.out.print(tens[n / 10]+" ");
           toWords(n % 10);
        }
        else{
           pos++;
           if (n < 1000) {
           toWords(n/100);
           System.out.print(spl[pos % 5]+" ");
           pos--;
           if (n % 100 != 0)
               System.out.print("and ");
           toWords(n % 100);
           }
           else {       
             pos++;
             if(n < 100000) {
             toWords(n/1000);
             System.out.print(spl[(pos % 5) ]+" ");
	     pos-=2 ;
             if(n %10000 != 0)
          
	     toWords(n%1000);
             }
             else {
                pos++;
                toWords(n/100000);
                System.out.print(spl[(pos % 5)]+" ");
                pos-=3;
                toWords(n %100000);
             }
	   }
        }
    }
}
