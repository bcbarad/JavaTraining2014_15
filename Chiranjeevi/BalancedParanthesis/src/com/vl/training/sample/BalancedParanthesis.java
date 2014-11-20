package com.vl.training.sample;

public class BalancedParanthesis {
    public static void main(String[] args) {
      /*  String s;
        DataInputStream d= new DataInputStream(System.in);
        System.out.println("Enter the expression:\t");
        s=d.readLine();
        checkExpression(s);*/
        System.out.println("result:"+checkExpression(args[0]));
    }
    public static boolean checkExpression(String arr){
        int i, balancedCondition=0;
       
        for(i=0;i<arr.length();i++) {
            if(arr.charAt(i)=='(') 
                balancedCondition++;
            else if(arr.charAt(i)==')') {
                if(balancedCondition > 0) 
                    balancedCondition--;
                else return(false);
            }
            else continue;
        }
        if(balancedCondition==0)
            return(true);
        else return(false);
    }
}
