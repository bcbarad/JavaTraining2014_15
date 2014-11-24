package com.vl.training.sample;

public class SecondMax {
    public static void main(String arr[]) {
        int[] val = new int[arr.length];
	for (int i = 0; i < arr.length; i++) {
	    val[i] = Integer.parseInt(arr[i]);
        }
        System.out.println("Second Maximum element is :" + secMaximum(val));
    }
    public static int secMaximum(int val[]) {
	int max = 0;
	int secMax = 0;
	for (int i : val) { //'val' is array of integers{
	    if (i > max) {
	        secMax = max; //make curr maximum to second maximum
		max = i;//make curr value to maximum calue
            }     
	    else if (i > secMax) {
	        secMax = i;
	    }
	}
	return secMax;
    }
}
