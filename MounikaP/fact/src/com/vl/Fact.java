package com.vl;
import java.io.*;
import java.util.*;
class Fact {
public static final void main(String args[]) {
private Fact {
}
Scanner sc = new Scanner(System.in);
System.out.println("enter n value");
int n = sc.nextInt();
int res = Fact.sequence(n);
System.out.println("result:"+res);
}
public static final int sequence(int n) {
int i = 0;
int res= 1, fact = 1;
while (n - 1 != 0) {
fact = fact * (i + 1) * (i + 2);
res = res + fact;
i = i + 2;
n--;
}
return res;
}
}

