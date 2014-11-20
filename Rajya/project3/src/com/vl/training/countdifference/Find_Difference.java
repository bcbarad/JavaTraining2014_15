package com.vl.training.countdifference;
import java.util.Scanner;
import java.lang.Math;

public class Find_Difference {

    public void Difference() {
        int nos[]=new int[4],diff,diff1,count=1,result,result1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 4 numbers:");
        for(int i=0;i<nos.length;i++) {
            nos[i]=sc.nextInt();
        }
        diff=Math.abs(nos[0])-Math.abs(nos[1]);
        result=Math.abs(diff);
        for(int j=2;j<nos.length;j++) {
            diff1=Math.abs(nos[j-1])-Math.abs(nos[j]);
            result1=Math.abs(diff1);
            if(result1==result) {
               count++;
            }    
        }
        if(count==3) 
        System.out.println("Difference between no's is equal");      
        else
        System.out.println("Difference between no's is not equal");
    }

    public static void main(String args[]) {
        Find_Difference fd=new Find_Difference();
        fd.Difference();
    }
}
