package com.vl.training.sample;
import java.util.Scanner;
import java.io.*;
interface Searchable {
    boolean max(Object o1,Object o2);
}
class TotalMaxHighest implements Searchable {
   public boolean max(Object o1, Object o2) {
       Student student1 = (Student)o1;
       Student student2 = (Student)o2;
       if (student1.total <= student2.total) {
           return true;
       }
       else {
           return false;
       }
    }
}
class SubjectHighest implements Searchable {
    String str = "";
    public SubjectHighest(String sname) {
        str = sname;
    }
    public boolean max(Object o1, Object o2) {
        Student st1 = (Student)o1;
        Student st2 = (Student)o2;
        if (st1.getSubjectMarks(str) <= st2.getSubjectMarks(str)) {
            return true;
        }
        else {
            return false;
        }
    }
}
public final class Course extends TotalMaxHighest {
    public int noofsubjects, noofstudents;
    public Student[] student;
    public static Scanner sc;
    public static void main(final String[] args) throws FileNotFoundException{
        int n;
        Course c = new Course();
        sc = new Scanner(new File(args[0]));
        c.noofstudents = sc.nextInt();
        c.noofsubjects = sc.nextInt();
        c.student = new Student[c.noofstudents];
        for (int i = 0; i < c.noofstudents; i++) {
            c.student[ i ] = Student.readme(sc, c.noofsubjects);
        }
        TotalMaxHighest tmh = new TotalMaxHighest();
        Object o = c.getMax(c.student,tmh);
        Student st = (Student)o;
        System.out.println("max marks of student"+st.sname+"is"+st.total);
        String sname = sc.next();
        SubjectHighest sh = new SubjectHighest(sname);
        Object s = c.getMax(c.student,sh);
        Student st2 = (Student)s;
        System.out.println("Student "+st2.sname+" Highest marks in subject"+sname+" is "+st2.getSubjectMarks(sname));
    }
    Object getMax(Object[] object,Searchable s) {
        Object max = object[0];
            for (int i = 1; i < object.length; i++) {
                if (s.max(max, object[i])) {
                    max = object[i];
                }
            }
            return max;
        }    
}
class Student {
    public String sname;
    public Score[] allmarks;
    public int n;
    public int total;
    static String[] names;
    static Student readme(final Scanner sc, final int ns) {
        Student st = new Student();
        st.sname = sc.next();
        st.n = ns;
        st.allmarks = new Score[st.n];
        int temp = 0;
        for (int i = 0; i < st.n; i++) {
            st.allmarks[i] = Score.readme(sc);
            temp = temp + st.allmarks[i].marks;
        }
         st.total = temp;
        return st;
    }
    int getSubjectMarks(String sub) {
        for (int i = 0; i < allmarks.length; i++) {
            if (sub.equals(allmarks[i].subname)) {
                return allmarks[i].marks;
            }
        }
        return 0;
    }
}
class Score {
    public String subname;
    int marks;
    public static Score readme(final Scanner sc) {
        String s = sc.next();
        int m = sc.nextInt();
        Score sco = new Score();
        sco.subname = s;
        sco.marks = m;
        return sco;
    }
}
