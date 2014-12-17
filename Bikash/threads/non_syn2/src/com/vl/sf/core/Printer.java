package com.vl.sf.core;
class Printer implements Runnable{
    String message;
    PrintMessage pm;
    Thread thread;
    Printer(PrintMessage pm, String message){
        this.message=message;
        this.pm=pm;
        thread=new Thread(this);
        thread.start();
    }
    public void run(){
        pm.printMessage(message);
    }
}

