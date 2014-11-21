package calculate.difference.chech.com;
import java.io.*;
import java.util.*;
public class Arraytest
{
 public static void main(String args[])throws IOException
 {
  
  int[] list=new int[50];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of  elements");
        int num=sc.nextInt();
        System.out.println(" enter elements");
  
        for(int i=0;i<num;i++)
        {
             list[i]=sc.nextInt();
        }
        Testing t=new Testing();
        boolean res=t.difference(list,num);
        System.out.println(res);
        if(res)
               System.out.println("differences are equal");
        else
               System.out.println("differences are not equal"); 
 }
}
class Testing
{
 public boolean difference(int diff[],int n)
 {
  int[] diff1 = new int[n];
  int i,var=0;
  for(i=0;i<n-1;i++)
  {
  int t=diff[i]-diff[i+1];
   diff1[i]=t;
   if(diff1[i]<0)
   diff1[i]=(-1)*diff1[i];
  }

  for(int j=0;j<i-1;j++)
  {
   if(diff1[j]!=diff1[j+1])
   {
   var=0;
   break;
  }
   else 
   var=1;
  }
  if(var==0)
  return false;
  else
  return true;
 }
}
  
