package com.vl.training.sample;
import java.util.Scanner;
public class MySample {
    public static int countWords(String str) {
	int count = 1 , j = 0;
	   for(int i = 0 ; i <= str.length() - 1 ; i++) {
		if ((str.charAt(i) == ' ')) {
		    count++;
		    j = i;
		    //  System.out.println(count);
			while ((str.charAt(j) == ' '))
                            {
				j++;
              			}
		    i = j - 1;
		    }
	    }
	    return count;
	}
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("enter a sentence");
	String sentence = in.nextLine();
	System.out.print("Your sentence has " + countWords(sentence) + " words.");
	}
}
