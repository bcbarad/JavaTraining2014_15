package com.vl.training.sample;
import java.util.HashMap;
import java.util.Map;

public class HashandEqualMethodsDemo {
    public static void main(String[] args) {
        Map m = new HashMap();
        StudentKey std = new StudentKey("ABC",12);

        m.put(std,new MarksValue(98));
        System.out.println(m);

        addElements(m);

    }

    public static void addElements(Map m) {
        StudentKey std = new StudentKey("ABC",12);

        MarksValue m1 = (MarksValue) m.get(std);
        System.out.println(m1);
        System.out.println(m);
    }
}



