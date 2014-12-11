package com.vl.sf.core;
public class Key{
    int n;
    String s;
    Key(String s, int n){
        this.s=s;
        this.n=n;
    }
    public boolean equals(Object obj){
        if(obj instanceof Key){
            Key k=(Key)obj;
            if(this.s.equals(k.s) && this.n==k.n){
                return true;
            }
        }
        return false;
    }
    public int hashCode(){
        return 10;
    }
}

