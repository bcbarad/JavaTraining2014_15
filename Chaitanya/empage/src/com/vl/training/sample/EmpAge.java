package com.vl.training.sample;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class EmpAge {
    public static void main(final String[] args) {
        if( args.length == 1) {
            List all = new ArrayList();
            all.add(new EmpAge("A", 25));
            all.add(new EmpAge("B", 30));
            all.add(new EmpAge("C", 60));
            all.add(new EmpAge("D", 30));
            all.add(new EmpAge("E", 50));
            EmpAge e = new EmpAge("F", 40);
            int age = Integer.parseInt(args[0]);
            e.removeOverAge(all, age);
        }
        else {
            System.out.println("give one command line argument");
        }
    }
    private String name;
    private int age;
    EmpAge(final String name, final int age) {
        this.name = name;
        this.age = age;
    }
    final void removeOverAge(final List all, final int age) {
        Iterator<EmpAge> i = all.iterator();
        while (i.hasNext()) {
            EmpAge e =  i.next();
            if (e.age > age) {
                i.remove();
            }
        }
        display(all);
    }
    final void display(final List all) {
        Iterator<EmpAge> i = all.iterator();
        while (i.hasNext()) {
            EmpAge e =  i.next();
            System.out.println("name" + e.name + "age" + e.age);
        }
    }
}

