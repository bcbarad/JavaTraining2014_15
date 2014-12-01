package com.vl.sf.core;

public class DigitToWordConverter {

	public static void main(String[] args) {
		String[] result = new String[1];
		result[0] = "";
		int num;

		num = Integer.parseInt(args[0]);
		if (DigitToWord(num, result) == true)
			System.out.println(num + "\t" + result[0]);

	}

	static public boolean divisor(int num, String[] result) {
		String[] oneToNinteen = { "One", "Two", "Three", "Four", "Five", "Six",
				"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
				"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen", };

		String[] tenToHundred = { "Ten", "Twenty", "Thirty", "Fourty",
				"Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred" };

		result[0] = "";
		int single, tens, hundreds;

		if (num > 1000)
			return false;

		hundreds = num / 100;
		num = num - hundreds * 100;
		if (num < 20) {
			tens = 0; // special case
			single = num;
		} else {
			tens = num / 10;
			num = num - tens * 10;
			single = num;
		}

		if (hundreds > 0) {
			result[0] += oneToNinteen[hundreds - 1];
			result[0] += " Hundred ";
		}
		if (tens > 0) {
			result[0] += tenToHundred[tens - 1];
			result[0] += " ";
		}
		if (single > 0) {
			result[0] += oneToNinteen[single - 1];
			result[0] += " ";
		}
		return true;
	}

	static public boolean DigitToWord(int num, String[] result) {
		String tempString[] = new String[1];
		tempString[0] = "";
		int thousands;
		int temp;
		result[0] = "";
		if (num < 0 || num > 100000) {
			System.out.println(num + " \tNot Supported");
			return false;
		}

		if (num == 0) {
			System.out.println(num + " \tZero");
			return false;
		}

		if (num < 1000) {
			divisor(num, tempString);
			result[0] += tempString[0];
		} else {
			thousands = num / 1000;
			temp = num - thousands * 1000;
			divisor(thousands, tempString);
			result[0] += tempString[0];
			result[0] += "Thousand ";
			divisor(temp, tempString);
			result[0] += tempString[0];
		}
		return true;
	}
}
