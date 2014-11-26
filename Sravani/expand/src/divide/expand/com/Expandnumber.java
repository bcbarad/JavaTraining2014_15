package divide.expand.com;
import java.util.Scanner;
public class Expandnumber {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Expandnumber en = new Expandnumber();
        String word = en.expand(num);
        System.out.println(word);
    }
    public final String expand(final int num) {
        int n = num;
        String[] ones = {"" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
        String[] tens = {"" , "ten" , "twenty" , "thirty" , "forty" , "fifty" , "sixty" , "seventy" , "eighty" , "ninety"};
        String[] teens = {"" , "eleven" , "twelve" , "thirteen" , "fourteen" , "fifteen" , "sixteen" , "seventeen" , "eighteen" , "nineteen"};
        String word = "";
        if (n >= 100000) {
            int quo = n / 100000;
            n = n % 100000;
            word = word + ones[quo] + "lakh" + " ";
        }
        if (n >= 1000) {
            int quotient = n / 1000;
            n = n % 1000;
            if (quotient > 10 && quotient < 20) {
                int rem = quotient % 10;
                word = word + teens[rem] + " " + "thousand" + " ";
            } else if (quotient > 20) {
                int rem = quotient % 10;
                int quo = quotient / 10;
                word = word + tens[quo] + ones[rem] + " " + "thousand" + " ";
            } else {
                word = word + ones[n] + "thousand" + " ";
            }
        }
        if (n >= 100) {
            int quo = n / 100;
            n = n % 100;
            word = word + ones[quo] + " " + "hundred" + " ";
        }
        if (n > 10 && n < 20) {
            int rem = n % 10;
            word = word + teens[rem] + " ";
        } else if (n > 20) {
            int rem = n % 10;
            n = n / 10;
            word = word + tens[n] + " " + ones[rem] + " ";
        } else {
            word = word + ones[n];
        }
        return word;
    }
}
