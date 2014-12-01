package com.vl.training.students;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public final class StudentMark {
    private StudentMark() {
    }
    public static void main(final String []args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
        Course c = new Course().readMe(scan);
        c.printDetails();
        String maxName = c.getMaxName();
        System.out.println("\nStudent got maximum marks is:" + maxName);
        c.highestMarks(scan);
    }
}

class Course {

    static int nostu;
    public Student[] allstudents = {};

    public Course readMe(final Scanner scan) {
        Course c = new Course();
        //System.out.println("Enter no of students:");
        Course.nostu = scan.nextInt();
        allstudents = new Student[Course.nostu];
        for (int i = 0; i < Course.nostu; i++) {
            allstudents[i] = new Student().readMe(scan);
        }
        return c;
    }

    public void printDetails() {
        int[] total = new int[Course.nostu];
        System.out.println("\n\nName\tsub1\tmarks1\tsub2\tmarks2\tsub3\tmarks3\ttotal");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < Course.nostu; i++) {
            System.out.print(allstudents[i].getName());
            for (int j = 0; j < Student.nosub; j++) {
                System.out.print("\t" + allstudents[i].allmarks[j].getSubjectName() + "\t" + allstudents[i].allmarks[j].getMarks());
                total[i] += allstudents[i].allmarks[j].getMarks();
            }
            System.out.println("\t" + total[i]);
        }
    }

    public String getMaxName() {
        int max = 0;
        String maxName = " ", maxStudent = " ";
        int[] tot = new int[Course.nostu];
         for (int i = 0; i < Course.nostu; i++) {
            System.out.print(allstudents[i].getName());
            for (int j = 0; j < Student.nosub; j++) {
                System.out.print("\t" + allstudents[i].allmarks[j].getSubjectName() + "\t" + allstudents[i].allmarks[j].getMarks());
                tot[i] += allstudents[i].allmarks[j].getMarks();
            }
            if (max < tot[i]) {
                max = tot[i];
                maxStudent = allstudents[i].getName();
            }
        }
        return maxName;
    }

    public void highestMarks(final Scanner scan) {
        //System.out.println("Enter the subjectname to find highest marks:");
        String subname = scan.next();
        String name = " ";
        int submark = 0, max = 0;
        for (int i = 0; i < Course.nostu; i++) {
            for (int j = 0; j < Student.nosub; j++) {
                if ((subname).equals(allstudents[i].allmarks[j].getSubjectName())) {
                    submark = allstudents[i].allmarks[j].getMarks();
                    if (max < submark) {
                        max = submark;
                        name = allstudents[i].getName();
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

    public Student readMe(final Scanner scan) {
        Student s = new Student();
        //System.out.println("Enter name:");
        name = scan.next();
        //System.out.println("Enter no of subjects:");
        Student.nosub = scan.nextInt();
        allmarks = new Score[Student.nosub];
        for (int i = 0; i < Student.nosub; i++) {
            allmarks[i] = new Score().readMe(scan);
        }
        return s;
    }

    public String getName() {
        return name;
    }
}

class Score {

    String subject;
    int marks;

    public Score readMe(final Scanner scan) {
        Score sc = new Score();
        //System.out.println("Enter subject, mark:");
        subject = scan.next();
        marks = scan.nextInt();
        return sc;
    }

    public int getMarks() {
        return marks;
    }

    public String getSubjectName() {
        return subject;
    }
}

