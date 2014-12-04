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
        System.out.print("Total maximum marks is:");
        StudentTotalMaxMarks st = new StudentTotalMaxMarks();
        Object b = c.getMaximumMarks(c.allstudents, st);
        System.out.print("Java maximum marks is:");
        StudentSubjectMaxMarks ss = new StudentSubjectMaxMarks();
        Object d = c.getMaximumMarks(c.allstudents, ss);
    }
}

interface Searchable {
    int maximum(Object ob1, Object ob2);
}

class StudentTotalMaxMarks implements Searchable {
    public int maximum(final Object ob1, final Object ob2) {
        Student s1 = (Student) ob1;
        Student s2 = (Student) ob2;
        if (s1.getTotalMarks() > s2.getTotalMarks()) {
            return s1.getTotalMarks();
        } else {
            return s2.getTotalMarks();
        }
    }
}

class StudentSubjectMaxMarks implements Searchable {
    public int maximum(final Object ob1, final Object ob2) {
        String subject = "java";
        Student s1 = (Student) ob1;
        Student s2 = (Student) ob2;
        if (s1.getMarks(subject) > s2.getMarks(subject)) {
            return s1.getMarks(subject);
        } else {
            return s2.getMarks(subject);
        }
    }
}

class Course {

    Student[] allstudents;

    public static Course readMe(final Scanner scan) {
        Course c = new Course();
        //System.out.println("Enter no of students:");
        int nostu = scan.nextInt();
        c.allstudents = new Student[nostu];
        for (int i = 0; i < nostu; i++) {
            c.allstudents[i] = Student.readMe(scan);
        }
        return c;
    }

    public void printDetails() {
        int[] total = new int[allstudents.length];
        System.out.println("\n\nName\tsub1\tmarks1\tsub2\tmarks2\ttotal");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < allstudents.length; i++) {
            System.out.print(allstudents[i].getName());
            for (int j = 0; j < allstudents[i].subject.length; j++) {
                System.out.print("\t" + allstudents[i].subject[j].getSubjectName() + "\t" + allstudents[i].subject[j].getMarks());
                total[i] += allstudents[i].subject[j].getMarks();
            }
            System.out.println("\t" + total[i]);
        }
    }

    Object getMaximumMarks(final Object []allstudents, final Searchable s) {
        Object max = allstudents[0];
        int maxMarks = 0, marks = 0;
        for (int i = 0; i < allstudents.length; i++) {
            maxMarks = s.maximum(max, allstudents[i]);
            if (maxMarks > marks) {
                max = allstudents[i];
                marks = maxMarks;
            }
        }
        System.out.println(marks);
        return max;
    }
}

class Student {
    private String name;
    private int nosub;
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

    int getTotalMarks() {
        int tot = 0;
        for (int j = 0; j < subject.length; j++) {
            tot += subject[j].getMarks();
        }
        return tot;
    }

    int getMarks(final String sub) {
        int submark = 0;
        for (int j = 0; j < subject.length; j++) {
            if ((sub).equals(subject[j].getSubjectName())) {
                submark = subject[j].getMarks();
            }
        }
        return submark;
    }
}

class Score {

    private String subject;
    private int marks;

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


