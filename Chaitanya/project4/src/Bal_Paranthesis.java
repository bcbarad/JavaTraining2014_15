package com.vl.training.sample;
class Balanced {
    void compute(String[] args) {
        char[] chr;
        int count=1,c=0;
        chr=args[0].toCharArray();
        for(int i=0;i<chr.length;i++) {
            if(chr[i]=='(')
                count++;
            if(chr[i]==')')
                count--;
            if(count>=1)
                continue;
            else break;
        }
        if(count==1)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}
public class Bal_Paranthesis {
    public static void main(String[] args) {
        Balanced bal=new Balanced();
        bal.compute(args);
    }
}
