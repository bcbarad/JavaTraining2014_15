//package com.vl.training.sample;
import java.util.Scanner;
interface Searchable {
    int max(Object o1,Object o2);
}
class TotalMaxHighest implements Searchable {
   public int max(Object o1, Object o2) {
       Student student1 = (Student)o1;
       Student student2 = (Student)o2;
       if (student1.total <= student2.total) {
            System.out.println("total1 "+student1.total);
            return -1;
       }
       else {
           System.out.println("else total1 "+student2.total);
           return 1;
       }
    }
}
public final class Course extends TotalMaxHighest {
    public static Course c;
    public int noofsubjects, noofstudents;
    public static Student[] student;
    public static Scanner sc;
    public static void main(final String[] args) {
        int n;
        c = new Course();
        System.out.println("Enter No Of Students");
        sc = new Scanner(System.in);
        c.noofstudents = sc.nextInt();
        System.out.println("Enter No oF Subjects");
        c.noofsubjects = sc.nextInt();
        //int[] temp = new int[c.noofstudents];
        student = new Student[c.noofstudents];
        for (int i = 0; i < c.noofstudents; i++) {
            c.student[ i ] = Student.readme(new Scanner(System.in), c.noofsubjects);
        }
        TotalMaxHighest tmh = new TotalMaxHighest();
        Object o = c.getMax(student,tmh);
        Student st = (Student)o;
        System.out.println("max marks are"+st.total);
    }
    Object getMax(Object[] student,Searchable s) {
        Object max = student[0];
        for (int i = 1; i < student.length; i++) {
            if (s.max(max, student[i]) < 0) {
                max = student[i];
                
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
   // public int[] total = {};
    static String[] names;
    static Student readme(final Scanner sc, final int ns) {
        //int count = 0;
        Student st = new Student();
        System.out.println("Enter Student name");
        st.sname = sc.nextLine();
        st.n = ns;
        // st.total = new int[ns];
        st.allmarks = new Score[st.n];
        int temp = 0;
        for (int i = 0; i < st.n; i++) {
            st.allmarks[i] = Score.readme(new Scanner(System.in));
            //System.out.println(st.allmarks[i].marks);
            temp = temp + st.allmarks[i].marks;
        }
        //st.total[count] = temp;
         st.total = temp;
        //count++;
        return st;
    }
}
class Score {
    public String subname;
    int marks;
    public static Score readme(final Scanner sc) {
        System.out.print("Enter subject name");
        String s = sc.nextLine();
        System.out.println("Enter Marks");
        int m = sc.nextInt();
        Score sco = new Score();
        sco.subname = s;
        sco.marks = m;
        return sco;
    }
}
