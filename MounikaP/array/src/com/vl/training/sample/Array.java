class Test
{
 public boolean consecutive(int arr[],int n)
 {  
 int i,var=1,j;
 int[] diff=new int[n-1];
 
 for(i=0;i<(n-1);i++)
 {
   diff[i]=arr[i+1]-arr[i];
   if(diff[i]<0)
   diff[i]=diff[i]*(-1);
   System.out.println(diff[i]);
}
   
  for(j=0;j<i-1;j++)
 {
  if(diff[j]!=diff[j+1])
  {
   var=0;
   break;
}
}
if(var==0)
return false;
else 
return true;
}
}
class Array
{
 public static void main(String args[])
 {
  int arr[]={0,1,2,3};
  Test a=new Test();
  int l=arr.length;
  boolean res=a.consecutive(arr,l);
 if(res)
  System.out.println("differences are equal.so its a consecutive array");
 else 
System.out.println("differences are not equal");

 }
} 
    
