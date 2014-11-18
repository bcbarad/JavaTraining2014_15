class Test
{
  public void balance(String s)
  {
    int i=0,depth=0;
    char[] arr=s.toCharArray();
    for(i=0;i<arr.length;i++)
    {
      if(arr[i]=='(')
       {  
         depth++;
       }
      if(arr[i]==')')
           {
            depth--;
           }
    if(depth<0)
    break;
   }
    System.out.println("depth=" +depth);
    if(depth!=0)
    {
     System.out.println(false);
     System.out.println("string is not balanced");
    }
    else
    {
    System.out.println("true");
    System.out.println("string is balanced");
   }
  }
 } 


class Braces
{
  public static void main(String args[])
  { 
   String s="((hello)";

   System.out.println("string is balanced");
   Test t = new Test();
   t.balance(s);
  }
}
    
   
