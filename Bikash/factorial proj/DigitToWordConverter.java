package com.vl.sf.core;

public class DigitToWordConverter {
	private static String digitInWord = "";
	private static int[] zeroRoundedNumbers = new int[] { 10, 100, 1000,
			100000, 10000000 };
	private static int stringLength = 0;
	private static String[] oneToTwenty = new String[] { "One", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fiften", "Sixteen", "Seventeen",
			"Eighteen", "Ninteen", "Twenty" };
	private static String[] thirtyToCrore = new String[] { "Thirty", "Fourty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred",
			"Thousand", "Lakh", "Crore" };

	public static void digitToWordConverter(int number) {
		int tempIndex = 0;
		if(number==0){
			System.out.println(digitInWord);
			System.exit(0);
		}
		else if (number <= 20) {
			digitInWord += oneToTwenty[number - 1] + " ";
		} else if (number <= 100) {
			tempIndex = (number / zeroRoundedNumbers[stringLength - 3]) - 3;
			digitInWord += thirtyToCrore[tempIndex] + " ";
		} else if (number <= 1000) {
			tempIndex = (number / zeroRoundedNumbers[stringLength - 3]) - 2;
			digitInWord += thirtyToCrore[tempIndex] + " ";

		} else if (number <= 100000) {
			tempIndex = (number /10000) - 1;
			digitInWord += thirtyToCrore[tempIndex] + " ";
		} else {
			tempIndex = (number / 1000000);
			digitInWord += thirtyToCrore[tempIndex] + " ";

		}

	}

	public static void main(String[] args) {
		int number = 1111;
		
		 if(number==0){
			 digitInWord+="Zero"; 
			 System.out.println(digitInWord);
		     System.exit(0); 
		 }
		
		stringLength = Integer.toString(number).length();
		if (stringLength == 5 || stringLength == 7) {
			stringLength--;
		}
		int cnt = 0;
		int divNumber=0;
		if(stringLength<=4){
			cnt = 2;
		}
		else if(stringLength==6){
			cnt=3;
		}else{
			cnt=4;
		}
		divNumber = number / zeroRoundedNumbers[stringLength - cnt];
		while (number != 0) {
			if (number <= 20) {
				digitToWordConverter(number);
				break;
			}
			if (number <= 100) {
				digitToWordConverter(number / 10 * 10);
				digitToWordConverter(number % 10);

			} else {
				if (divNumber <= 20) {
					digitToWordConverter(divNumber);
				} else if (divNumber <= 99) {
					digitToWordConverter(divNumber / 10 * 10);
					digitToWordConverter(divNumber % 10);
				} else {
					digitToWordConverter(number / 10 * 10);
					digitToWordConverter(number % 10);
				}
				digitToWordConverter(zeroRoundedNumbers[stringLength - cnt]);
				number %= zeroRoundedNumbers[stringLength - cnt];
				cnt++;
				divNumber = number / zeroRoundedNumbers[stringLength - cnt];
			}

		}
		System.out.println(digitInWord);
	}
}
