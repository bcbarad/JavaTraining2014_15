package com.vl.training.sample;

public class TwinPrime {
	public static void main(String arr[]){
		//checking the no. of inputs as 2
		if(arr.length == 2) {
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			System.out.println("" + areTwinPrimes(a,b));		
		}
		else{
			System.out.println("Insufficient inputs");
		}
	}
	public static boolean areTwinPrimes(int a, int b) {
		if( isPrime(a) && isPrime(b) ){
			if(a - b == 2 || b - a == 2)
				return true;//System.out.println(a+"and "+b+"are TwinPrimes");
			else return false;
		}
		return false;
	}
	public static boolean isPrime(int x) {
		for(int i = 2 ; i < Math.sqrt(x) ; i++){
			if(x % i == 0)
				return false;
		}
		return true;
	}
}
