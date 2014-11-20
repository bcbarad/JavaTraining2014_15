package paranthesis.prog.com;
import java.io.*;
public class WordCount
{
 public static void main(String args[])throws IOException
 {
  System.out.println("enter the sentence");
  String str;
  InputStreamReader input = new InputStreamReader(System.in);
  BufferedReader reader = new BufferedReader(input); 
  str=reader.readLine();
  int count=0;
  Count c=new Count();
  count=c.wordcount(str);
  System.out.print("no. of words:"+count);
}
}
class Count
{
 int wordcount(String str)
 {
 int i=0,count1=0;
  char prevchar=' ', presentchar=str.charAt(0);
  while(str.charAt(i)!='\0')
  {
   if(prevchar==' '&&(presentchar!=' '||presentchar!='\n'))
   count1++;
   prevchar=presentchar;
   i++;
   if(i>=(str.length()))
   {
    break;
    }
    else
    {
     presentchar=str.charAt(i);
    }
   }
   return count1;
  }
}
   
 
