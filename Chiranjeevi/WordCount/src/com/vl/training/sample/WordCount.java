package com.vl.training.sample;

public class WordCount {
    public static void main(String arr[]) {
        System.out.println("Total no. of words:"+totalWords(arr[0]));
    }
    public static int totalWords(String str) {
        int count=0,i=0;
        while(str.charAt(i)==' ' || str.charAt(i)=='\t' || str.charAt(i)=='\n') {
            i++;
        }
        for(;i<str.length();i++) {
            if(str.charAt(i)==' ' || str.charAt(i)=='\t' ||str.charAt(i)=='\n') {
                if(str.charAt(i-1)!=' ' || str.charAt(i-1)!='\t' || str.charAt(i-1)!='\n')
                    count++;
            }
        }
    return(++count);
    }
}
