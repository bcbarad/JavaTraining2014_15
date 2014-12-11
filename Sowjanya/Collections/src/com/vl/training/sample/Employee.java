package com.vl.training.sample;
import java.util.*;
public final class Employee {
    private Employee() {
    }
    public static void main(final String[] args) {
        Map m = new HashMap();
        EmpTest et1 = new EmpTest("ion" , 7071 , 10000);
        m.put(et1 , "ion details");
        toCheck(m);
    }
    public static void toCheck(final Map m) {
        EmpTest et2 = new EmpTest("ion" , 7071 , 10000);
        String result = (String) m.get(et2);
        System.out.println(result);
        System.out.println(m);
    }
}

