package com.vl.training.wordsinstring;
import java.util.Scanner;

public class WordsString {

    public final int findWords() {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to count no of words in a string:");
        name = sc.nextLine();
        int count = 1;
        for (int i = 1; i < name.length(); i++) {
            if ((name.charAt(i - 1) == ' ') && (name.charAt(i) != ' ')) {
                count++;
            }
        }
        return count;
    }

    public static void main(final String[] args) {
        WordsString ws = new WordsString();
        int result;
        result = ws.findWords();
        System.out.println("No of words in a string are:" + result);
    }
}
