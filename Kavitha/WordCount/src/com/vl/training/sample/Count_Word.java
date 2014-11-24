package com.vl.training.sample;

import java.util.Scanner;
public class Count_Word{
    public static void main(String[] args){
        count(); 
    }
    public static void count(){
//reading  a sentence from the user
    System.out.println("Enter a sentence");
    Scanner scn=new Scanner(System.in);
    String sent=scn.nextLine();
//converting string to character array
    char[] ch=sent.toCharArray();
    int i,count=1;
    for(i=0;i<ch.length;i++){
        while(ch[i]==' '){
            i++;
        if(ch[i]!=' ')
            count++;
        }
    }   
    System.out.println("No of words are"+count);    
}
}

