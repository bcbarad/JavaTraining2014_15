package com.vl.training.students;
import java.util.Scanner;

public class StudentMark {
    public static void main(final String []args) {
        Scanner scan = new Scanner(System.in);
        Course cc = new Course();
        Course c = Course.readMe(scan);
    }
}

class Course {

    static int nostu;
    public Student[] allstudents = {};

    public static Course readMe(final Scanner scan) {
        Course c = new Course();
        System.out.println("Enter no of students:");
        Course.nostu = scan.nextInt();
        c.allstudents = new Student[Course.nostu];
        for (int i = 0; i < Course.nostu; i++) {
            c.allstudents[i] = Student.readMe(scan);
        }
        int[] total = new int[Course.nostu];
        int max = 0;
        String maxStudent = " ";
        System.out.println("\n\nName\tsub1\tmarks1\tsub2\tmarks2\tsub3\tmarks3\ttotal");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < Course.nostu; i++) {
            System.out.print(c.allstudents[i].name);
            for (int j = 0; j < Student.nosub; j++) {
                System.out.print("\t" + c.allstudents[i].allmarks[j].subject + "\t" + c.allstudents[i].allmarks[j].marks);
                total[i] += c.allstudents[i].allmarks[j].marks;
            }
            System.out.println("\t" + total[i]);
            if (max < total[i]) {
                max = total[i];
                maxStudent = c.allstudents[i].name;
            }
        }
        System.out.println("\nStudent got maximum marks is:" + maxStudent);
        return c;
    }
}

class Student {
    public String name;
    static int nosub;
    public Score[] allmarks = {};

    public static Student readMe(final Scanner scan) {
        Student s = new Student();
        System.out.println("Enter name:");
        s.name = scan.next();
        System.out.println("Enter no of subjects:");
        Student.nosub = scan.nextInt();
        s.allmarks = new Score[Student.nosub];
        for (int i = 0; i < Student.nosub; i++) {
            s.allmarks[i] = Score.readMe(scan);
        }
        return s;
    }

}

class Score {

    public String subject;
    public int marks;

    public static Score readMe(final Scanner scan) {
        Score sc = new Score();
        System.out.println("Enter subject, mark:");
        sc.subject = scan.next();
        sc.marks = scan.nextInt();
        return sc;
    }
}

