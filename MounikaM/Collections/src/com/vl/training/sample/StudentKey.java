package com.vl.training.sample;

class StudentKey {
    public String sname;
    public int sRollNo;

    public StudentKey(String name, int rollNo) {
        this.sname = name;
        this.sRollNo = rollNo;
    }
    public boolean equals(Object obj) {
        boolean n = false;
        if (obj == null) {
            n = false;
        }
        if (obj  instanceof StudentKey) {
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

