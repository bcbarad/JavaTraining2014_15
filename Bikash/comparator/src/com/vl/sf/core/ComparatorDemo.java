package com.vl.sf.core;
import java.util.TreeSet;
public class ComparatorDemo {
    public static void main(String[] args) {
        TreeSet set=new TreeSet();
        set.add(new Example(25));
        set.add(new Example(5));
        set.add(new Example(45));
        set.add(new Example(34));
        System.out.println(set);
        TreeSet treeSet=new TreeSet(new ExampleComparator());
        treeSet.add(new Example(25));
        treeSet.add(new Example(5));
        treeSet.add(new Example(45));
        treeSet.add(new Example(34));
        System.out.println(treeSet);
    }
  }
