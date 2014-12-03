package com.vl.training.sample;
import java.util.Scanner;
interface Max {
    abstract void getTotalHighest(Course c);
    abstract void getIndividualHighest(Course c);
}
class Maxi implements Max{
    public void getTotalHighest(Course c) {
        int highmax = 0;
        String highname = "";
        for (int i = 0; i < c.noofstudents; i++) {
            int marks = 0;
            for (int j = 0; j < c.noofsubjects; j++) {
                marks = marks + c.student[ i ].total[j];
                if (marks > highmax) {
                    highmax = marks;
                    highname = c.student[ i ].sname;
                }
            }
        }
        System.out.println("high marks are\t" + highmax + "name\t" + highname);
    }
    public void getIndividualHighest(Course c) {
        System.out.println("Enter subject name that You want to get maximum");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int max = 0;
        String name = "";
        for (int i = 0; i < c.noofstudents; i++) {
            for (int j = 0; j < c.noofsubjects; j++) {
                if (str.equals(c.student[ i ].allmarks[j].subname)) {
                    if (max < c.student[ i ].allmarks[ j ].marks) {
                        max = c.student[ i ].allmarks[ j ].marks;
                        name = c.student[ i ].sname;
                    }
                }
            }
        }
        System.out.println("student name" + name + "marks are" + max);
    }
}
public final class Course extends Maxi {
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
        c.getTotalHighest(c);
        c.getIndividualHighest(c);
    }
    /*static void getTotalHighest() {
        int highmax = 0;
        String highname = "";
        for (int i = 0; i < c.noofstudents; i++) {
            int marks = 0;
            for (int j = 0; j < c.noofsubjects; j++) {
                marks = marks + c.student[ i ].total[j];
                if (marks > highmax) {
                    highmax = marks;
                    highname = c.student[ i ].sname;
                }
            }
        }
        System.out.println("high marks are\t" + highmax + "name\t" + highname);
    }*/
    static void getIndividualHighest() {
        System.out.println("Enter subject name that You want to get maximum");
        String str = sc.next();
        int max = 0;
        String name = "";
        for (int i = 0; i < c.noofstudents; i++) {
            for (int j = 0; j < c.noofsubjects; j++) {
                if (str.equals(c.student[ i ].allmarks[j].subname)) {
                    if (max < c.student[ i ].allmarks[ j ].marks) {
                        max = c.student[ i ].allmarks[ j ].marks;
                        name = c.student[ i ].sname;
                    }
                }
            }
        }
        System.out.println("student name" + name + "marks are" + max);
    }
}
class Student {
    public String sname;
    public Score[] allmarks;
    public int n;
    public int[] total = {};
    static String[] names;
    static Student readme(final Scanner sc, final int ns) {
        int count = 0;
        Student st = new Student();
        System.out.println("Enter Student name");
        st.sname = sc.nextLine();
        st.n = ns;
        st.total = new int[ns];
        st.allmarks = new Score[st.n];
        int temp = 0;
        for (int i = 0; i < st.n; i++) {
            st.allmarks[i] = Score.readme(new Scanner(System.in));
            //System.out.println(st.allmarks[i].marks);
            temp = temp + st.allmarks[i].marks;
        }
        st.total[count] = temp;
        count++;
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
