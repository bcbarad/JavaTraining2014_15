package com.vl.training.wordsinstring;
import java.util.Scanner;

public class Words_String {

    String name;

    public void Read_String() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string to count no of words in a string:");
        name=sc.nextLine();
    }

    public int Find_Words() {
        int count=1;
        for(int i=1;i<name.length();i++) {
            if(((name.charAt(i-1)==' ')||(name.charAt(i-1)=='\t')||(name.charAt(i-1)=='\n'))&&((name.charAt(i)!=' ')&&(name.charAt(i)!='\t')&&(name.charAt(i)!='\n')))
                count++;
        }
        return count;
    }

    public static void main(String args[]) {
        Words_String ws=new Words_String();
        int result;
        ws.Read_String();
        result=ws.Find_Words();
        System.out.println("No of words in a string are:"+result);
    }
}
