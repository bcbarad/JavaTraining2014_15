package com.vl.training.numberconversion;

public class ConvertNumber {

    public final String formatNumber(final int no) {
        String []ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String []tens = {"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String []middles = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        int digit1, digit2, digit3, digit4, digit21, digit31;
        String value = " ";
        int length = (int) Math.log10(no) + 1;
        if (length == 1) {
            if (no == 0) {
                value = " zero";
            } else {
                value = ones[no - 1];
            }
        }
        if (length == 2) {
            if (no > 10 && no < 20) {
                value = middles[no - 11];
            } else {
                digit1 = no / 10;
                digit2 = no % 10;
                if (digit1 == 0) {
                    value = ones[digit2 - 1];
                }
                if (digit2 == 0) {
                    value = tens[digit1 - 1];
                } else {
                    value = tens[digit1 - 1] + ones[digit2 - 1];
                }
            }
        }
        if (length == 3) {
            digit1 = no / 100;
            digit2 = no % 100;
            digit21 = (digit2) / 10;
            digit3 = (digit2) % 10;
            if (digit21 == 0) {
                if (digit3 == 0) {
                    value = ones[digit1 - 1] + " hundred";
                } else {
                    value = ones[digit1 - 1] + " hundred " + ones[digit3 - 1];
                }
            } else {
                if (digit2 > 10 && digit2 < 20) {
                    value = ones[digit1 - 1] + " hundred " + middles[digit2 - 11];
                } else {
                      if (digit3 == 0) {
                        value = ones[digit1 - 1] + " hundred " + tens[digit21 - 1];
                    } else {
                        value = ones[digit1 - 1] + " hundred " + tens[digit21 - 1] + ones[digit3 - 1];
                    }
                }
            }
        }
        return value;
    }

    public static void main(final String []args) {
        ConvertNumber cn = new ConvertNumber();
        int no = Integer.parseInt(args[0]);
        String result = cn.formatNumber(no);
        System.out.println(result);
    }
}
