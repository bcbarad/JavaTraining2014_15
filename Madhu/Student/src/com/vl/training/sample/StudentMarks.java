package com.vl.training.sample;
import java.util.Scanner;
import java.io.*;
public class StudentMarks {
    private StudentMarks() {
    }
    private Student[] allstudents;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));
        int stucount = sc.nextInt();
        int subcount = sc.nextInt();
        StudentMarks sm = new StudentMarks();
        sm.allstudents = new Student[stucount];
        for (int i = 0; i < stucount; i++) {
            sm.allstudents[i] = Student.readMe(subcount , i , sc);
        }
        Object max = sm.getMax(sm.allstudents , new StudentHighTotal());
        Student sthigh = (Student) max;
        System.out.println("The highest score gained by:  " + sthigh.name + "  and score be:  " + sthigh.total1);
        String sub = sc.next();
        Object maxsub = sm.getMax(sm.allstudents , new SubjectHighestStudent(sub));
        Student subhigh = (Student) maxsub;
        System.out.println("The student: " + subhigh.name + " get highest marks in " + sub + " with : "+subhigh.getSubMarks(sub));
    } 
    static Object getMax(Object[] allObjects , Searchable s) {           // returns the highest object
        Object max = allObjects[0];
        for (int i = 1; i < allObjects.length; i++) {
            if (s.isGreater(max , allObjects[i])) {
                max = allObjects[i];
            }
        }
        return max;
    }
} 
class Student {
    public String name;
    public Marks[] allMarks;
    public int  total1;
    public static  Student readMe(int subcount , int i , Scanner sc) {    // read the name of student and move to get the sujects and marks
        int total = 0;
        Student ss = new Student();
        ss.name = sc.next();
        ss.allMarks = new Marks[subcount];
        for (int j = 0; j < subcount; j++) {
            ss.allMarks[j] = Marks.readMe(j , sc);
            total += ss.allMarks[j].marks;
        }
        ss.total1 = total;
        return ss;
    }
    public int  getSubMarks(String subject) {
        int marks = 0;
        for (int i = 0; i < allMarks.length; i++) {
            if (subject.equals(allMarks[i].subject)) {
                marks = allMarks[i].marks;
            }
        }
        return marks;
    }
}

class Marks {
    public String subject;
    public int marks;
    public static  Marks readMe(int j , Scanner sc) {  //  read the subjects and the marks
        Marks mm = new Marks();
        mm.subject = sc.next();
        mm.marks = sc.nextInt();
        return mm;     // returns the Marks object to student class
    }
}

interface Searchable {
    boolean  isGreater(Object obj1 , Object obj2);
}
class StudentHighTotal implements Searchable {
    public  boolean isGreater(Object obj1 , Object  obj2) {    // returns true if obj1 total < obj2 total
        Student st1 = (Student)obj1;
        Student st2 = (Student)obj2;
        if (st1.total1 < st2.total1) {
            return true;
        } else {
            return false;
        }
    }
}
class SubjectHighestStudent implements Searchable {
    String subject;
    SubjectHighestStudent(String subject) { 
        this.subject = subject;
    }
    public boolean isGreater(Object obj1 , Object obj2) {     // returns  true if obj1 marks < obj2 marks
        Student st1 = (Student)obj1;
        Student st2 = (Student)obj2;
        if (st1.getSubMarks(subject) < st2.getSubMarks(subject)) {
            return true;
        } else {
            return false;
        }
    }
}


















