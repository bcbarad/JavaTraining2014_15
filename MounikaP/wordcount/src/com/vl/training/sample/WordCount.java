class Test1 {
	  public void word(String s)
	  {
	     int i=0,count=0;
	     char a[]=new char[50];
	     for(i=0;i<s.length();i++)
	     {
	      a[i]=s.charAt(i);
	      if(((i>0)&&(a[i]!=' ')&&(a[i-1]==' '))||((a[0]!=' ')&&(i==0)))

	         count++;

	       }
        
	     System.out.println(count);
	   }
	 }
	class WordCount
	{
	  public static void main(String args[])
	  {
		  String s="Value labs";
	       Test1 w=new Test1();
	   w.word(s);
	  }
	}
   
