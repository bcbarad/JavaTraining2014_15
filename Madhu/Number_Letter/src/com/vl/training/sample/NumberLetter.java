package com.vl.training.sample;
public final  class NumberLetter {
    private NumberLetter() {
    }
    private static int temp , quotient;
    private static String textnum = " ";
    private static String[] ones = {"" , " one " , " two " , " three " , " four " , " five " , " six "  , " seven " , " eight " , " nine " };
    private static String[] tens = {"" , " ten " ,  " twenty " , " thirty " , " fourty " , " fifty " , " sixty " , " seventy " , " eighty " , " ninety " };
    private static String[] teens = {"" , " eleven " , " twelve " , " thirteen " , " fourteen " , " fifteen " , " sixteen " , " seventeen " , " eighteen " , " nineteen " };
    static String converter(final int num) {
        int number = num;
        if (number >= 100000) {
            quotient = number / 100000;
            number = number % 100000;
            textnum = textnum + ones[quotient] + " lakh ";
        }
        if (number >= 1000) {
            quotient = number / 1000;
            NumberLetter.tenss(quotient);
            number = number % 1000;
            textnum += " thousand ";
        }
        if (number >= 100) {
            quotient = number / 100;
            textnum += ones[quotient] + " hundred ";
            number = number % 100;
        }
        NumberLetter.tenss(number);
        return textnum;
    }
    public static void tenss(final int num1) {
        int num = num1;
        if (num > 10 && num < 20) {
            temp = num % 10;
            textnum += teens[temp];
            return;
        } else {
            temp = num / 10;
            textnum = textnum + tens[temp];
            num = num % 10;
        }
        textnum = textnum + ones[num];
    }
    public static void main(final String[] args) {
        int num = Integer.parseInt(args[0]);
        String str = NumberLetter.converter(num);
        System.out.println("    " + str);
    }
}

