package com.vl.training.sample;
import java.util.Scanner;
public class Course {
    private  static Course c;
    private int ns, n;
    private static Student[] student;
    private static Scanner sc;
    public static void main(final String[] args) {
        int n;
        c = new Course();
        System.out.println("Enter No Of Students");
        sc = new Scanner(System.in);
        c.n = sc.nextInt();
        System.out.println("Enter No oF Subjects");
        c.ns = sc.nextInt();
        int[] temp = new int[c.n];
        student = new Student[c.n];
        for (int i = 0; i < c.n; i++) {
            c.student[ i ] = Student.readme(new Scanner(System.in), c.ns);
        }
        Course.getTotalHighest();
        Course.getIndividualHighest();
    }
    static void getTotalHighest() {
        int highmax = 0;
        String highname = "";
        for (int i = 0; i < c.n; i++) {
            int marks = 0;
            for (int j = 0; j < c.n; j++) {
                marks = marks + c.student[ i ].allmarks[ j ].marks;
                if (marks > highmax) {
                    highmax = marks;
                    highname = student[ i ].sname;
                }
            }
        }
        System.out.println("high marks are\t" + highmax + "name\t" + highname);
    }
    static void getIndividualHighest() {
        System.out.println("Enter subject name that You want to get maximum");
        String str = sc.next();
        int max = 0;
        String name = "";
        for (int i = 0; i < c.n; i++) {
            for (int j = 0; j < c.ns; j++) {
                if (str.equals(c.student[ i ].allmarks[ j ].subname)) {
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
    public int n, total = 0;
    public static String[] names;
    static Student readme(final Scanner sc, final int ns) {
        Student st = new Student();
        System.out.println("Enter Student name");
        st.sname = sc.nextLine();
        st.n = ns;
        st.allmarks = new Score[st.n];
        int temp = 0;
        for (int i = 0; i < st.n; i++) {
            st.allmarks[i] = Score.readme(new Scanner(System.in));
            System.out.println(st.allmarks[i].marks);
            temp = temp + st.allmarks[i].marks;
        }
        st.total = temp;
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
