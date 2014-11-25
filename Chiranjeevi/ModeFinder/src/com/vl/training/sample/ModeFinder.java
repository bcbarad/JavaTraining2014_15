package com.vl.training.sample;

public class ModeFinder {
    public static void main(String arr[]) {
        int[] val = new int[arr.length];
        System.out.print("Mode of");
       for (int i = 0; i < arr.length; i++) {
            val[i] = Integer.parseInt(arr[i]);
            System.out.print(" " + val[i]);
        }
        System.out.println("is :" + getMode(val));
    }
    public static int getMode(int[] a) {
        int mode=a[0],count=1,temp=1,i;
        for (i = 0; i < a.length-1; i++) {
            if (a[i] == a[i+1])
                temp++;
            else if (temp >= count) {
                mode = a[i];                
                count = temp;
                temp = 0;
            }
            else {
                temp=1;
            }          
        }
        if (temp >= count) {
            mode = a[i];
            count = temp;
        }
    return mode;
    }
}
