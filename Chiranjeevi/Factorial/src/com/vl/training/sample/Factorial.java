//package com.vl.training.sample;

public class Factorial {
	public static void main(String arr[]) {
		int n = Integer.parseInt(arr[0]);
		System.out.println("output: " + facSum(n));
	}
	public static int facSum(int n){
		int tmp,sum=0;
		for (int i=n;i>0;i--){
			tmp = 1; // important to reset
			for (int j=1;j<=i;j++){
				tmp *= j;
			}
			sum+=tmp;
		}
		return sum;
	} 

}
