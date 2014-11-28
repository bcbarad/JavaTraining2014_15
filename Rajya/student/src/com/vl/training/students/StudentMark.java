package com.vl.training.students;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public final class StudentMark {
    private StudentMark() {
    }
    public static void main(final String []args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
        Course cc = new Course();
        Course c = Course.readMe(scan);
        int[] tot = cc.printDetails(c);
        String maxStudent = cc.maximumMarks(tot, c);
        System.out.println("\nStudent got maximum marks is:" + maxStudent);
        //System.out.println("Enter the subjectname to find highest marks:");
        String subname = scan.next();
        cc.highestMarks(scan, c, subname);
    }
}

class Course {

    static int nostu;
    public Student[] allstudents = {};

    public static Course readMe(final Scanner scan) {
        Course c = new Course();
        //System.out.println("Enter no of students:");
        Course.nostu = scan.nextInt();
        c.allstudents = new Student[Course.nostu];
        for (int i = 0; i < Course.nostu; i++) {
            c.allstudents[i] = Student.readMe(scan);
        }
        return c;
    }

    public int[] printDetails(Course c) {
        int[] total = new int[Course.nostu];
        System.out.println("\n\nName\tsub1\tmarks1\tsub2\tmarks2\tsub3\tmarks3\ttotal");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < Course.nostu; i++) {
            String n = Student.getName(c, i);
            System.out.print(n);
            for (int j = 0; j < Student.nosub; j++) {
                System.out.print("\t" + Student.getSubject(c, i, j) + "\t" + Student.getMarks(c, i, j));
                total[i] += Student.getMarks(c, i, j);
            }
            System.out.println("\t" + total[i]);
        }
        return total;
    }

    public String maximumMarks(final int[] tot, final Course c) {
        int max = 0;
        String maxStudent = " ";
        for (int i = 0; i < tot.length; i++) {
            if (max < tot[i]) {
                max = tot[i];
                maxStudent = Student.getName(c, i);
            }
        }
        return maxStudent;
    }

    public void highestMarks(final Scanner scan, final Course c, final String subname) {
        String name = " ";
        int submark = 0, max = 0;
        for (int i = 0; i < Course.nostu; i++) {
            for (int j = 0; j < Student.nosub; j++) {
                if ((subname).equals(Student.getSubject(c, i, j))) {
                    submark = Student.getMarks(c, i, j);
                    if (max < submark) {
                        max = submark;
                        name = Student.getName(c, i);
                    }
                }
            }
        }
        System.out.println(" " + name + " got highest marks of " + max + " in suject " + subname);
    }
}

class Student {
    public String name;
    static int nosub;
    public Score[] allmarks = {};

    public static Student readMe(final Scanner scan) {
        Student s = new Student();
        //System.out.println("Enter name:");
        s.name = scan.next();
        //System.out.println("Enter no of subjects:");
        Student.nosub = scan.nextInt();
        s.allmarks = new Score[Student.nosub];
        for (int i = 0; i < Student.nosub; i++) {
            s.allmarks[i] = Score.readMe(scan);
        }
        return s;
    }

    public static String getName(final Course c, final int i) {
        String sname = c.allstudents[i].name;
        return sname;
    }

    public static int getMarks(final Course c, final int i, final int j) {
        int mrk;
        mrk = c.allstudents[i].allmarks[j].marks;
        return mrk;
    }

    public static String getSubject(final Course c, final int i, final int j) {
        String sub;
        sub = c.allstudents[i].allmarks[j].subject;
        return sub;
    }
}

class Score {

    String subject;
    int marks;

    public static Score readMe(final Scanner scan) {
        Score sc = new Score();
        //System.out.println("Enter subject, mark:");
        sc.subject = scan.next();
        sc.marks = scan.nextInt();
        return sc;
    }
}

