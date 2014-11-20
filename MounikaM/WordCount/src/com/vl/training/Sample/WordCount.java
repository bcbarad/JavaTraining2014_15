
 class WordCount{
  public static int countingNumberOfWords(String str){
   int count=0;
   int len=str.length();
   char ch[]=new char[len];
   for(int i=0;i<len;i++)
   {
     ch[i]=str.charAt(i);
     if(((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)))
     {
        count++;
     }
   }
   return count;
  }   
  public static void main(String args[])
  {
   int count=WordCount.countingNumberOfWords(" Demonstartion of number of words in string ");
   System.out.println(" the number of words in the sentence are:"+count);
  }
}

