package com.vl.training.sample;


import java.util.Scanner;
public class Paran {
public static void main(String[] args) {
    Paran.paran();
} 
public static void  paran(){
    int depth=0,i;
        System.out.println(" enter a string");
//reading a string from the user
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//converting string to character array
        char[] a=str.toCharArray();
        for(i=0;i<a.length&&depth>=0;i++) {
            if(a[i]=='(')
                depth++;
            if(a[i]==')')
                depth--;
        }
        if(depth==0)
            System.out.println("true");
        else
            System.out.println("false");
}
}
