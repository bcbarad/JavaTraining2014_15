package com.vl.training.sample;
class Key {
    private int id;
    private String sname;
    Key(final String sname1, final int id1) {
        sname = sname1;
        id = id1;
    }
    public boolean equals(final Object o) {
        if (o instanceof Key) {
            Key k = (Key) o;
            if (this.id == k.id && this.sname.equals(k.sname)) {
                return true;
            }
        }
        return false;
    }
    public int hashCode() {
        return id;
    }
}
