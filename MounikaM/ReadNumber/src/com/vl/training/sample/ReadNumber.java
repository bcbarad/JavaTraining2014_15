package com.vl.training.sample;


public class ReadNumber {
    public static void main(final String[] args) {
        ReadNumber rd = new ReadNumber();
        int number = Integer.parseInt(args[0]);
        String s = rd.findEngFormOfNumber(number);
        System.out.println(number + " = " + s);
    }
    public String findEngFormOfNumber(int number) {
        String[] ones = {" ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] teens = {" ", "eleven", "twelve", "thirteen", "fourteen", "fiveteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {" ", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int index = 0;
        String s = " ";
        if (number == 0) {
            s = s + " Zero ";
        }
        if (number >= 1000 && number < 10000) {
            index = number / 1000;
            number = number % 1000;
            s = ones[index] + " Thousand and  ";
        }

        if (number >= 100 && number < 1000) {
            index = number / 100;
            number = number % 100;

            s = s + ones[index] + " hundred and ";
        }
        if (number >= 11 && number <= 19) {
            index = number % 10;
            s = s + teens[index];

        }
        if (number >= 20 && number < 100) {
            index = number / 10;
            number = number % 10;
            s = s + tens[index - 1];

        }
        if (number < 10) {
            index = number % 10;
            s = s + ones[index];
        }
        return s;
    }
}
