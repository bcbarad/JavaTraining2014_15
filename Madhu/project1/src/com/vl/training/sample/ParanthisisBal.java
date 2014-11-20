package com.vl.training.sample;
public class ParanthisisBal
{
    static boolean checkParnthBal(String str)
    {
         int openpar=0,closepar=0,i=0;
         int strlen=str.length();
         char ch[]=new char[strlen];
         for(;i<strlen;i++)
         {
              ch[i]=str.charAt(i);
              if(ch[i]=='(')
                   openpar++;
              else if(ch[i]==')')
                   closepar++;
              if(openpar==closepar)
                   openpar=closepar=0;
              else if(closepar>openpar)
                   return false;
         }
         if(openpar==closepar)
              return true;
         else
              return false;
    }
    public static void main(String args[])
    {
       boolean res=ParanthisisBal.checkParnthBal(" ((A ) (D)(( ");
       if(res)
           System.out.println(" string paranthisis balenced ");
       else
           System.out.println(" string paranthisis not balanced");
    }

}
