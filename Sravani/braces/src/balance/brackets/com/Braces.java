package balance.brackets.com;
import java.io.*;
public class Braces
{
 public static void main(String args[])throws IOException
 {
  System.out.println("enter the sentence using braces");
  String str;
  InputStreamReader input = new InputStreamReader(System.in);
  BufferedReader reader = new BufferedReader(input); 
  str=reader.readLine();
  boolean balance;
  Calculate c=new Calculate();
  balance=c.test(str);
  if(balance==true)
  System.out.println("paranthesis balanced");
  else
  System.out.println("paranthesis not balanced");
 }
}
class Calculate
{
 public boolean test(String str)
 {
  int count=0,i=0;
  while(str.charAt(i)!='\0')
{
  if(str.charAt(i)=='(')
  count++;
  else if(str.charAt(i)==')')
   count--;
   if(count<0)
  break;
  i++;
}
  if(count!=0)
  return false;
  else
  return true;  
 }
}
