package com.vl.training.sample;
import java.util.Scanner;
public class WordCount
{
	static int countWords(String str)
	{
		int count=0,i=0;
		int strlen=str.length();
		char ch[]=new char[strlen];
		for(;i<strlen;i++)
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
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string;");
		String  sentence=sc.nextLine();
		int count=WordCount.countWords(sentence);
		System.out.println(" the number of words in the sentence are:"+count);
	}
}

