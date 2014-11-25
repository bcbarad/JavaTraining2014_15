package com.vl.training.Sample;

public class BalanceParanthesis {
    public static void main(final String []args) {
        boolean d = BalanceParanthesis.balanceCheck(" ( This) ( ( py))");
        if (d) {
            System.out.println("\n braces are balanced in given string");
        } else {
            System.out.println("\n braces are not balanced in given string:");
        }
    }

    static boolean balanceCheck(final String s) {
        int count = 0;
        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == '(') {
                count += 1;
            } else if (s.charAt(index) == ')') {
                if (count >= 0) {
                    count -= 1;
                }  else {
                    break;
                }
            } else {
                continue;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}

