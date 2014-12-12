package com.vl.sf.core;
public class Example implements Comparable{
    int x;
    Example(){}
    Example(int x){
        this.x=x;
    }
    @Override
    public int compareTo(Object o) throws ClassCastException{
        if(o instanceof Example){
            Example e=(Example)o;
            return this.x-e.x;
        }else {
            throw new ClassCastException();
        }
    }
    @Override
    public String toString() {
        return Integer.toString(x);
    }
}

