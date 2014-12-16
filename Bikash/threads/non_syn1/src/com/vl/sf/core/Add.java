package com.vl.sf.core;
class Add{
    int x,y;
    public int add(int x, int y){
        this.x=x;
        this.y=y;
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        int result=this.x+this.y;
        return result;
    }
}
