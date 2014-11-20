package com.vl.training.sample;
class Word_Compute {
    void compute(String[] args) {
        int count=1;
        char[] chr_Array;
        chr_Array=args[0].toCharArray();
            for(int i=0;i<chr_Array.length;i++) {
            if(chr_Array[i]==' ') {
            count++;
                while(chr_Array[i]==' ') {
                    i++;
                }
            }
        }
        System.out.println("Word count is "+count);
    }
}
public class Word_Count {
    public static void main(String[] args)
        {
            Word_Compute wc=new Word_Compute();
                wc.compute(args);
        }
}

