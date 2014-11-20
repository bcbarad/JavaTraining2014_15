package com.vl.training.sample;
import java.lang.*;
class Arr_Ele_Diff_Compute {
    int i,temp;
    boolean compute(String[] args) {
        int[] formal_args=new int[args.length];
        for(i=0;i<args.length;i++) {
            formal_args[i]=Integer.parseInt(args[i]);
        }
        int diff=formal_args[0]-formal_args[1];
        for(i=1;i<args.length-1;i++) {
            if(diff==(formal_args[i]-formal_args[i+1]))
                continue;
            else {
                temp=1;
                break;
            }
        }
        if(temp==1)
            return false;
        else return true;
    }
}
public class Arr_Ele_Diff {
    public static void main(String[] args) {
        Arr_Ele_Diff_Compute com=new Arr_Ele_Diff_Compute();
        boolean b=com.compute(args);
        if(b==true)
            System.out.println("true");
        else
            System.out.println("false");   
    }
}    
