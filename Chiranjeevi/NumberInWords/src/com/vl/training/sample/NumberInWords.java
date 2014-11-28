package com.vl.training.sample;

public class NumberInWords {
    public static int pos;
    public static String inWords="";
    public static void main(String[] arr) {
        if (arr.length == 1) {
            int n = Integer.parseInt(arr[0]);
            if (n == 0){
                System.out.println("Zero");
            }
            else if (n > 0 ) {
                System.out.println(toWords(n));                
            }
            else {
                System.out.println("Please enter a positive integer");
            }
        }
        else {
            System.out.println("Pass Exactly one number");
        }
    }
    public static String toWords(int n) {
        String[] ones = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        String[] tens = {"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty"};
        String[] spl = {"","hundred","thousand","lakh","crore"};        
        if(n < 20) {
            inWords = inWords + ones[n%20]+" ";
        }
        else if (n < 100) {
            inWords = inWords + tens[n / 10]+" ";
            toWords(n % 10);
        }
        else{
            pos++;
            if (n < 1000) {
                toWords(n/100);
                inWords = inWords + spl[pos % 5]+" ";
                pos--;
                if (n % 100 != 0)
                    inWords = inWords + "and ";
                toWords(n % 100);
            }
            else {       
                pos++;
                if(n < 100000) {
                toWords(n/1000);
                inWords = inWords + spl[(pos % 5) ]+" ";
	        pos-=2 ;
                toWords(n%1000);
                }
                else {
                    pos++;
                    toWords(n/100000);
                    inWords = inWords + spl[(pos % 5)]+" ";
                    pos-=3;
                    toWords(n %100000);
                }
	    }
        }
        return inWords;
    }
}
