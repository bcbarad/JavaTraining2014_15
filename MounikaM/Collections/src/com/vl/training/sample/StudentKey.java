package com.vl.training.sample;
import java.util.HashMap;
import java.util.Map;

class StudentKey {
    String sname;
    int sRollNo;

    public StudentKey(String name, int rollNo) {
        this.sname = name;
        this.sRollNo = rollNo;
    }
    public boolean equals(Object obj) {
        boolean n = false;
        if(obj == null) {
            return false;
        }
        else if ( obj  instanceof StudentKey ) {
            StudentKey std = (StudentKey) obj;

            if (this.sRollNo == std.sRollNo) {
                n = true;
            }
        }
        return n;
    }
    public int hashCode() {
        return (int) sname.length() * this.sRollNo;
    }
}
class MarksValue {
    int marks;

    public MarksValue(int m) {
        marks = m;
    }
}

