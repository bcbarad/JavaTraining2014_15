package com.vl.training.sample;

public class ConsecutiveDifference {
    public static void main(String[] args) {
        System.out.println("answer:"+checkDifference(args));
    }
    public static boolean checkDifference(String[] arr) {
        int i,diff;
        int[] val=new int[arr.length];
        for(i=0;i<arr.length;i++) {
            val[i]=Integer.parseInt(arr[i]);
        }
        diff=val[0]-val[1];
        for(i=2;i<arr.length;i++) {
            if( diff==(val[i]-val[i-1]) || diff==(val[i-1]-val[i]) ) {
                continue;
            }
            else return(false);
        }
        return(true);
    }
}

