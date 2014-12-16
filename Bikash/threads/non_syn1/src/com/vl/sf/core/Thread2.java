package com.vl.sf.core;
class Thread2 extends Thread{
    Add a;
    Thread2(Add a){
        this.a=a;
    }
    public void run(){
        int result=a.add(70,80);
        System.out.println("The addition of 70 and 80 is: "+result);
    }
}
