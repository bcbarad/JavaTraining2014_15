//package com.vl.training.sample;
public class Prime {
	public static void main(final String[] args) {
		int[] a = new int[args.length];
		for(int i = 0;i<args.length; i++) {
			a[i] = Integer.parseInt(args[i]);
		}
		boolean f=Prime.getPrime(a);
		System.out.println(f);

	}
	static boolean getPrime(int[] a) {
		boolean f1=false,f2=false;
		if(a.length==2) {

			int x=a[0];
			int y=a[1];
			if(Math.abs(x-y)==2) {
				f1=compute(x);
				f2=compute(y);
			}
			else 
				return false;
		}
		if(f1&&f2) 
			return true;
		else 
			return false;


	}              


	static boolean compute(int a)
	{
		boolean flag=false;
		for(int i=2;i<Math.sqrt(a);i++) {
			if(a%i==0) 
				flag=true;
		} 
		if(flag)
			return false;
		else 
			return true;
	}
}
