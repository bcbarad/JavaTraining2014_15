package com.vl;
import java.util.*;
public class Key {
    public static int n;
    public static String s;
    public Key(String s, int n) {
        super();
        this.s = s;
        this.n = n;
    }
    public int hashCode() {
        return n + s.hashCode();
    }
    public boolean equals( Object obj) {
        if (obj instanceof Key) {
            Key k = (Key) obj;
            return (this.s.equals(k.s) && this.n == k.n);
        } else {
        return false;
    }
    }
}
