package com.vl.training.sample;
import java.util.Map;
import java.util.HashMap;
public class Student {
    public static void main(final String[] args) {
        Map hm = new HashMap();
        Key k1 = new Key("chaitanya", 7080);
        hm.put(k1, "value1");
        Student st = new Student();
        String val = st.getValue(hm);
        System.out.println("Value is " + val);
    }
    final String getValue(final Map m) {
        Key k1 = new Key("chaitanya", 7080);
        //m.put(k1,"Value2");
        String val = (String) m.get(k1);
        //System.out.println(m);
        return val;
    }
}
