package com.vl.sf.core;

public class DigitToWordConverter2 {
	
	
	
    private static int[] zeroRoundedNumbers = new int[] { 10, 100, 1000,
		100000, 10000000 };

	public static void main(String[] args) {
		String[] result=new String[1];
		result[0]=""; 
		int number=Integer.parseInt(args[0]);
		boolean status=converter(number,result);
		if(status){
			System.out.println(result[0]);
		}
			
	}
	
	public static boolean digitToWord(int number,String[] result) {
		String[] oneToTwenty = new String[] { "One", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fiften", "Sixteen", "Seventeen",
			"Eighteen", "Ninteen", "Twenty" };
	    String[] thirtyToCrore = new String[] { "Thirty", "Fourty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred",
			"Thousand", "Lakh", "Crore" };
		int tempIndex = 0;
		
		if(number==0){
			System.out.println(result[0]);
			return false;
		}
		else if (number <= 20) {
			result[0]+= oneToTwenty[number - 1] + " ";
		} else if (number <= 100) {
			tempIndex = (number /10) - 3;
			result[0]+= thirtyToCrore[tempIndex] + " ";
		} else if (number <= 1000) {
			tempIndex = (number /100) - 2;
			result[0]+= thirtyToCrore[tempIndex] + " ";

		} else if (number <= 100000) {
			tempIndex = (number /10000) - 1;
			result[0]+= thirtyToCrore[tempIndex] + " ";
		} else {
			tempIndex = (number / 1000000);
			result[0]+= thirtyToCrore[tempIndex] + " ";
		}
		return true;

	}
	public static int divisor(int number, String[] result){
		int f=0;
		int cnt = 0;
		int stringLength=Integer.toString(number).length();
		if(stringLength<=4){
			cnt = 2;
		}
		else if(stringLength<=6){
			cnt=3;
		}else{
			cnt=4;
		}
		boolean status=false;
		f=number / zeroRoundedNumbers[stringLength - cnt];
		
		if(f<=20){
			status=digitToWord(f,result);
		}else{
			status=digitToWord(f/10*10,result);
			status=digitToWord(f%10,result);
		}
		
		status=digitToWord( zeroRoundedNumbers[stringLength - cnt],result);
		number=number% zeroRoundedNumbers[stringLength - cnt];
		return number;
	}

	public static boolean converter(int number, String[] result){
		boolean status=false;
		while(number>=100){
			number=divisor(number,result);
		}
		
		if(number<=20){
			status=digitToWord(number,result);
		}else{
			status=digitToWord(number/10*10,result);
			
			status=digitToWord(number%10,result);
		}
		return status;
		
	}
}
