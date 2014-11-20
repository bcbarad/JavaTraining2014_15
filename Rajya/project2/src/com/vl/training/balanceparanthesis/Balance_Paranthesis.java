package com.vl.training.balanceparanthesis;
import java.util.Scanner;

public class Balance_Paranthesis {

    String word;

    public void Read_String() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string to find Paranthesis in a string are balanced or not:");
        word=sc.nextLine();
    }

    public void Find_Balance() {
        int depth=0;
        for(int i=0;i<word.length();i++) {
            if(depth>=0) {
            if(word.charAt(i)=='(')
                depth++;
            else if(word.charAt(i)==')')
                depth--;
            }
        }
        if(depth==0)
            System.out.println("Given string contains balanced paranthesis");
        else
            System.out.println("Given string doesn't contain balanced paranthesis");
            
    }

    public static void main(String args[]) {
        Balance_Paranthesis bp=new Balance_Paranthesis();
        bp.Read_String();
        bp.Find_Balance();
    }

}
