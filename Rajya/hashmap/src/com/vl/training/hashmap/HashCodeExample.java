package com.vl.training.hashmap;
import java.util.HashMap;
import java.util.Map;

public final class HashCodeExample {

    private HashCodeExample() {
    }

    public static void main(final String []args) {
        Map<Key, String> m = new HashMap<Key, String>();
        Key k = new Key("apple", 100);
        m.put(k, "banana");
        addElements(m);
    }

    public static void addElements(final Map m) {
        Key k = new Key("apple", 100);
        String name = (String) m.get(k);
        System.out.println(name);
    }
}

class Key {
    private String fruit;
    private int cost;

    public Key(final String f, final int c) {
        this.fruit = f;
        this.cost = c;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Key) {
            Key key = (Key) obj;
            return (key.fruit.equals(this.fruit) && key.cost == this.cost);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int value = cost * 5;
        value += fruit.hashCode();
        return value;
    }
}
