package com.vl.training.sample;
import java.io.*;      
public class FileIndentation { 
    static char space=' ';    
    public static void main(String args[])throws IOException {    
        FileInputStream fin=new FileInputStream("/home/sowjanya/PrjTest/JavaTraining2014_15 /Sowjanya/Indentation/src/com/vl/training/sample/Example.java");  
        FileOutputStream fout=new FileOutputStream("/home/sowjanya/PrjTest/JavaTraining2014_15 /Sowjanya/Indentation/src/com/vl/training/sample/Output.java",true);  
        int i=0;
        byte[] b=new byte[fin.available()];
        int depth=0;     
        fin.read(b);
   try {
        for(int p=0;p<b.length-1;p++) {
            char ch=(char)b[p];
            fout.write(ch);
            if (ch=='{') {    
                depth+=4;
                print(depth,fout);
                /*for(int j=0;j<depth;j++) {
                    fout.write(space);
                }*/
            }
            char ch1=(char)b[p+1];
            if (ch1=='}') {
                depth-=4;
                print(depth,fout);
                /*for(int k=0;k<depth;k++) {
                    fout.write(space);    
                }*/  
                fout.write(ch);                
            } 
            if(ch=='\n') {
                print(depth,fout);
                /*for(int k=0;k<depth;k++) {
                    fout.write(space);    
                }*/
            } 
            if(ch==' ') {
               fout.write(ch);
            }                      
        }
   }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            fin.close();
            fout.close();
        }
    }  
    public static void print(int depth,FileOutputStream fout) throws IOException {
        for(int j=0;j<depth;j++) {
            fout.write(space);
        } 
    }
}    
