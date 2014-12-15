package com.vl.training.sample;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
class Student {
    private String name;
    private int marks;
    Student(final String sname , final int smarks) {
        this.name = sname;
        this.marks = smarks;
    }
    void setName(final String sname) {
        this.name = sname;
    }
    String getName() {
        return name;
    }
    void setMarks(final int smarks) {
        this.marks = smarks;
    }
    int getMarks() {
        return marks;
    }
    public int compareTo(final Student s) {
        return (this.name).compareTo(s.getName());
    }
}
public final class ComparatorandComparableExample {
    private ComparatorandComparableExample() {
    }
    public static void main(final String[] args) {

        Student st1 = new Student("ion" , 42);
        Student st2 = new Student("aarish" , 41);
        Student st3 = new Student("sai" , 40);
        List<Student> al = new ArrayList<Student>();
        al.add(st1);
        al.add(st2);
        al.add(st3);
        System.out.println("Before sort:");
        for (Student s : al) {
            System.out.println(s.getMarks());
        }
        Collections.sort(al , new marksComparator());
        System.out.println("After sort based on marks:");
        for (Student s : al) {
            System.out.println(s.getMarks() + s.getName());
        }
        Collections.sort(al , new nameComparator());
        System.out.println("After sort based on name:");
        for (Student s : al) {
            System.out.println(s.getName() + s.getMarks());
        }
    }
}
class marksComparator implements Comparator<Student> {
    public int compare(final Student st1 , final Student st2) {
        int st1marks = st1.getMarks();
        int st2marks = st2.getMarks();
        if (st1marks > st2marks) {
            return 1;
        } else if (st1marks < st2marks) {
            return -1;
        } else {
            return 0;
        }
    }
}


