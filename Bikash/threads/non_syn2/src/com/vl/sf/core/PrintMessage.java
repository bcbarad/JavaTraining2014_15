package com.vl.sf.core;
class PrintMessage{
    public void printMessage(String message){
        System.out.print("["+message);
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.print("]");
    }
}
