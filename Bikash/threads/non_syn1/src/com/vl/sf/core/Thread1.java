package com.vl.sf.core;
class Thread1 extends Thread{
    Add a;
    Thread1(Add a){
        this.a=a;
    }
    public void run(){
        int result=a.add(50,60);
        System.out.println("Addition of 50 and 60 is: "+result);
    }
}

