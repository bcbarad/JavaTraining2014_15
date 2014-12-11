package com.vl;
import java.util.*;
class Hash {
    public static void f(Map m) {
        Key k1 = new Key("ABC", 100);
        String s = (String)m.get(k1);
        System.out.println(s);
        System.out.println(m);
    }
    public static void main(String[] args) {
        Map m = new HashMap();
        Key k1 = new Key("ABC", 100);
        m.put(k1, "value");
        f(m);
    }
}
