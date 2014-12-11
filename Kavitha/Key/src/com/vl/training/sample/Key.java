package com.vl.training.sample;
import java.util.*;

public class Key {
    int n;
    String s;
    Key(final String s, final int n) {
        this.n = n;
        this.s = s;
    }
    public static void main(final String []args) {
        Map<Key, String> m = new HashMap<Key, String>();
        Key k1 = new Key("ABC", 100);
        m.put(k1, "1000");
        k1.fun(m);
    }
    final void fun(Map m) {
        Key k1 = new Key("ABC", 100);
        String result = (String) m.get(k1);
        System.out.println(" " + result);
    }
    public boolean equals(final Object obj) {
        if (this.s == s && this.n == n) {
            return true;
        } else {
            return false;
          }
    }
    public int hashCode() {
        return 3 * n + s.hashCode();
    }
}
