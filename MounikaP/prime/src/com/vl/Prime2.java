import java.io.*;
import java.util.*;
class Prime2{
public static final void main(String args[]){
private Prime2{
}
Scanner sc = new Scanner(System.in);
System.out.println("enter a and b values");
int a = sc.nextInt();
int b = sc.nextInt();
if(((a-b)==2)||((a-b)==-2) && primeCheck(a) && primeCheck(b)){
System.out.println("true");
}
else{ 
System.out.println("invalid");
}
}
public static final boolean primeCheck(int n){
for (int i = 2;i <= Math.sqrt(n);i++){
if(n % i == 0){
return false;
}
}
return true;
}
}





