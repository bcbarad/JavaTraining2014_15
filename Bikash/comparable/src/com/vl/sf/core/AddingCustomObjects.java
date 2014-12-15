package com.vl.sf.core;
import java.util.TreeSet;
public class AddingCustomObjects {
    public static void main(String[] args){
        TreeSet set=new TreeSet();
        set.add(new Example(98));
        set.add(new Example(10));
        set.add(new Example(54));
        System.out.println(set);
    }
}

