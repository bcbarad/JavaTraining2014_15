package com.vl.sf.core;

public class DigitToWordConverter2 {
	
	private static String digitInWord="";
	private static int stringLength = 0;
	private static String[] oneToTwenty = new String[] { "One", "Two", "Three",
		"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
		"Twelve", "Thirteen", "Fourteen", "Fiften", "Sixteen", "Seventeen",
		"Eighteen", "Ninteen", "Twenty" };
    private static String[] thirtyToCrore = new String[] { "Thirty", "Fourty",
		"Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred",
		"Thousand", "Lakh", "Crore" };
    private static int[] zeroRoundedNumbers = new int[] { 10, 100, 1000,
		100000, 10000000 };

	public static void main(String[] args) {
		converter(1500);
		System.out.println(digitInWord);
	}
	
	public static void digitToWord(int number) {
		int tempIndex = 0;
		if(number==0){
			System.out.println(digitInWord);
			System.exit(0);
		}
		else if (number <= 20) {
			digitInWord += oneToTwenty[number - 1] + " ";
		} else if (number <= 100) {
			tempIndex = (number /10) - 3;
			digitInWord += thirtyToCrore[tempIndex] + " ";
		} else if (number <= 1000) {
			tempIndex = (number /100) - 2;
			digitInWord += thirtyToCrore[tempIndex] + " ";

		} else if (number <= 100000) {
			tempIndex = (number /10000) - 1;
			digitInWord += thirtyToCrore[tempIndex] + " ";
		} else {
			tempIndex = (number / 1000000);
			digitInWord += thirtyToCrore[tempIndex] + " ";

		}

	}
	public static int divisor(int number){
		int f=0;
		int cnt = 0;
		
		if(stringLength<=4){
			cnt = 2;
		}
		else if(stringLength==6){
			cnt=3;
		}else{
			cnt=4;
		}
		f=number / zeroRoundedNumbers[stringLength - cnt];
		if(f<=20){
			digitToWord(f);
		}else{
			digitToWord(f/10*10);
			digitToWord(f%10);
		}
			digitToWord( zeroRoundedNumbers[stringLength - cnt]);
			number=number% zeroRoundedNumbers[stringLength - cnt];
		return number;
	}

	public static void converter(int number){
		stringLength=Integer.toString(number).length();
		int f;
		if(number==0){
			digitInWord+="Zero";
			System.out.println(digitInWord);
			System.exit(0);
		}
		if(number>=10000000){
			number=divisor(number);
		}
		if(number>=100000){
			number=divisor(number);
		}
		if(number>=1000){
			number=divisor(number);
		}
		if(number>=100){
			f=number/100;
			digitToWord(f);
			digitToWord(100);
			number=number%100;
		}
		if(number<=20){
			digitToWord(number);
		}else{
			//System.out.println(number/10*10);
			digitToWord(number/10*10);
			
			digitToWord(number%10);
		}
	}
}
