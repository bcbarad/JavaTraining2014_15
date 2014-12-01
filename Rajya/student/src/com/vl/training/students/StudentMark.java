package com.vl.training.students;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public final class StudentMark {
    private StudentMark() {
    }
    public static void main(final String []args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(args[0]));
        Course c = new Course();
        c = c.readMe(scan);
        c.printDetails();
        String maxName = c.getMaxName();
        System.out.println("\nStudent got maximum marks is:" + maxName);
        c.highestMarks(scan);
    }
}

class Course {

    int nostu;
    Student[] student;

    public static Course readMe(final Scanner scan) {
        Course c = new Course();
        //System.out.println("Enter no of students:");
        c.nostu = scan.nextInt();
        c.student = new Student[c.nostu];
        for (int i = 0; i < c.nostu; i++) {
            c.student[i] = Student.readMe(scan);
        }
        return c;
    }

    public void printDetails() {
        int[] total = new int[nostu];
        System.out.println("\n\nName\tsub1\tmarks1\tsub2\tmarks2\ttotal");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < nostu; i++) {
            System.out.print(student[i].getName());
            for (int j = 0; j < student[i].subject.length; j++) {
                System.out.print("\t" + student[i].subject[j].getSubjectName() + "\t" + student[i].subject[j].getMarks());
                total[i] += student[i].subject[j].getMarks();
            }
            System.out.println("\t" + total[i]);
        }
    }

    public String getMaxName() {
        int max = 0;
        String maxStudent = " ";
        int[] tot = new int[nostu];
        for (int i = 0; i < nostu; i++) {
            for (int j = 0; j < student[i].subject.length; j++) {
               tot[i] += student[i].subject[j].getMarks();
            }
            if (max < tot[i]) {
                max = tot[i];
                maxStudent = student[i].getName();
            }
        }
        return maxStudent;
    }

    public void highestMarks(final Scanner scan) {
        //System.out.println("Enter the subjectname to find highest marks:");
        String subname = scan.next();
        String name = " ";
        int submark = 0, max = 0;
        for (int i = 0; i < student.length; i++) {
            for (int j = 0; j < student[i].subject.length; j++) {
                if ((subname).equals(student[i].subject[j].getSubjectName())) {
                    submark = student[i].subject[j].getMarks();
                    if (max < submark) {
                        max = submark;
                        name = student[i].getName();
                    }
                }
            }
        }
        System.out.println(name + " got highest marks of " + max + " in subject " + subname);
    }
}

class Student {
    String name;
    int nosub;
    Score[] subject;

    static Student readMe(final Scanner scan) {
        Student s = new Student();
        Score sc = new Score();
        //System.out.println("Enter name:");
        s.name = scan.next();
        //System.out.println("Enter no of subjects:");
        s.nosub = scan.nextInt();
        s.subject = new Score[s.nosub];
        for (int i = 0; i < s.nosub; i++) {
            s.subject[i] = Score.readMe(scan);
        }
        return s;
    }

    String getName() {
        return name;
    }
}

class Score {

    String subject;
    int marks;

    static Score readMe(final Scanner scan) {
        Score sc = new Score();
        //System.out.println("Enter subject, mark:");
        sc.subject = scan.next();
        sc.marks = scan.nextInt();
        return sc;
    }

    int getMarks() {
        return marks;
    }

    String getSubjectName() {
        return subject;
    }
}

