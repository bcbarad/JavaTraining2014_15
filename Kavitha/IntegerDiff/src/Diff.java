package com.vl.training.sample;

import java.util.Scanner;
public class Diff {
public static void main(String[] args) {
    Diff.sample();
}
static void sample() {
int flag=0,i;
Scanner sc=new Scanner(System.in);
//reading how many no's we want to enter into array
System.out.println("Enter total no of values");
int n=sc.nextInt();
int b[]=new int[n];
//reading values from the user
System.out.println("Enter values");
for(i=0;i<n;i++)
{
b[i]=sc.nextInt();
}
//finding the diff b/w first two integers
int diff=b[0]-b[1];
for(i=1;i<b.length-1;i++)
{
//comparing the differences every time
	if(diff==(b[i]-b[i+1])||diff==(b[i+1]-b[i] ))
		continue;
	else 
	{
		flag=1;
		break;
	}
}
if(flag==1) 
	System.out.println("Not equal");
else
	System.out.println("equal");
}
}
