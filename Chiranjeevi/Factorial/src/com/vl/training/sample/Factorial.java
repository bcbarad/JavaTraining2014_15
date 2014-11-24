//package com.vl.training.sample;

public class Factorial {
	public static void main(String arr[]) {
		int n = Integer.parseInt(arr[0]);
		int a = 0;
		for( int i = 1 ; i <= n ; i++ ) {
			System.out.print(i + "! + ");
			a = a + factorial( i );

		}
		System.out.println(" = " + a);
	}
	public static int factorial(int n) {

		if ( n == 1) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}
}
