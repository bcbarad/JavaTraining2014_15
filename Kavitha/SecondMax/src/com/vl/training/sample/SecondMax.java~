//package com.vl.training.sample;
public class SecondMax {
    public static void main(final String[] args) {
        int[] a = new int[args.length];
        for(int i = 0;i<args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        SecondMax.getSMax(a);
        
    }
    static void getSMax(final int[] a) {
           if(a.length > 2) {
                int max = a[0],sMax=a[0];
        
                for(int i = 1; i < a.length-1; i++) {
                    if(max < a[ i ]) {
                        sMax=max;
                        max = a[ i ];
                    }
                    if(sMax < a[i+1])
                     sMax=a[i+1];
                }
            System.out.println("The second Maximum is"+sMax);
            }
            else
                 System.out.println("you have to enter atleast 1 element");
    }     
}
