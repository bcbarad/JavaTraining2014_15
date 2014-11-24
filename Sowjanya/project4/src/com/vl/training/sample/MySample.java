package com.vl.training.sample;
import java.util.Scanner;
public class MySample {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("enter total no of values");
int n=sc.nextInt();
int array[]=new int[n];
System.out.println("enter the values in to array");
for(int i=0;i<n;i++)
array[i]=sc.nextInt();
boolean output=MySample.sample(array);
if(output)
System.out.println("equal");
else
System.out.println("not equal");
}
static boolean sample(int array[])
{
int diff1=0,diff2=0;
for(int i=1;i<array.length-2;i++)
{
diff1=array[i]-array[i+1];
diff2=array[i+1]-array[i+2];
}
if(diff1==diff2)
return true;
else
return false;
}
}
