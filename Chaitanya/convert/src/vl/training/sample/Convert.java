package com.vl.training.sample;
public final class Convert {
    public static void main(final String[] args) {
        int n = Integer.parseInt(args[0]);
        Convert.converter(n);
    }
    private static String result = " ";
    private static String[] ones = {"" , " one " , " two " , " three " , " four " , " five " , " six " , " seven " , " eight " , " nine " };
    private static String[] tens = {"" , " ten " , " twenty " , " thirty " , " fourty " , " fifty " , " sixty " , " seventy " , " eighty " , " ninety " };
    private static String[] teens = {"" , " eleven " , " twelve " , " thirteen " , " fourteen " , " fifteen " , " sixteen " , " seventeen " , " eighteen " , " nineteen " };
    static void converter(final int number) {
        int n = number, temp = 0, quotient = 0;
        if (n >= 100000) {
            quotient = n / 100000;
            n = n % 100000;
            result = result + ones[quotient] + " lakh ";
        }
        if (n >= 1000) {
            quotient = n / 1000;
            Convert.digittwo(quotient);
            n = n % 1000;
            result = result + " thousand ";
        }
        if (n >= 100) {
            quotient = n / 100;
            result += ones[quotient] + " hundred ";
            n = n % 100;
        }
        Convert.digittwo(n);
        System.out.println(result);
    }
    public static void digittwo(final int num1) {
        int num = num1, temp = 0;
        if (num > 10 && num < 20) {
            temp = num % 10;
            result = result + teens[temp];
            return;
        } else {
            temp = num / 10;
            result = result + tens[temp];
            num = num % 10;
        }
        result = result + ones[num];
    }
}
