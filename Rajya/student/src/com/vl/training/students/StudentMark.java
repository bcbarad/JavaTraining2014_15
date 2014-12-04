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
        StudentTotalMaxMarks stm = new StudentTotalMaxMarks();
        Object b = c.getMaximum(c.allStudents, stm);
        Student s = (Student) b;
        System.out.println(s.getName() + " got total maximum marks of " + s.getTotalMarks());
        StudentSubjectMaxMarks ssm = new StudentSubjectMaxMarks("java");
        Object d = c.getMaximum(c.allStudents, ssm);
        Student s1 = (Student) d;
        System.out.print(s1.getName() + " got highest marks of " + s1.getSubjectMarks("java") + " in Java");
    }
}

interface Searchable {
    // if ob1 > ob2 => true
    // else ob2 > ob1 => false
    boolean maximum(Object ob1, Object ob2);
}

class StudentTotalMaxMarks implements Searchable {
    
    public boolean maximum(final Object ob1, final Object ob2) {
        Student s1 = (Student) ob1;
        Student s2 = (Student) ob2;
        if (s2.getTotalMarks() > s1.getTotalMarks()) {
            return true;
        } else {
            return false;
        }
    }
}

class StudentSubjectMaxMarks implements Searchable {
    
    private  String subject;
    StudentSubjectMaxMarks(String s) {
        this.subject = s;
    }
    public boolean maximum(final Object ob1, final Object ob2) {
        Student s1 = (Student) ob1;
        Student s2 = (Student) ob2;
        if (s2.getSubjectMarks(subject) > s1.getSubjectMarks(subject)) {
            return true;
        } else {
            return false;
        }
    }
}

class Course {

    Student[] allStudents;

    public static Course readMe(final Scanner scan) {
        Course c = new Course();
        //System.out.println("Enter no of students:");
        int nostu = scan.nextInt();
        c.allStudents = new Student[nostu];
        for (int i = 0; i < nostu; i++) {
            c.allStudents[i] = Student.readMe(scan);
        }
        return c;
    }

    public void printDetails() {
        int[] total = new int[allStudents.length];
        System.out.println("\n\nName\tsub1\tmarks1\tsub2\tmarks2\ttotal");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < allStudents.length; i++) {
            System.out.print(allStudents[i].getName());
            for (int j = 0; j < allStudents[i].subject.length; j++) {
                System.out.print("\t" + allStudents[i].subject[j].getSubjectName() + "\t" + allStudents[i].subject[j].getMarks());
                total[i] += allStudents[i].subject[j].getMarks();
            }
            System.out.println("\t" + total[i]);
        }
    }

    // Assumption: S knows only array of allObjects
    Object getMaximum(final Object []allObjects, final Searchable s) {
        Object max = allObjects[0];
        for (int i = 0; i < allObjects.length; i++) {
            boolean b = s.maximum(max, allObjects[i]);
            if (b) {
                max = allObjects[i];
            }
        }
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

    int getSubjectMarks(final String sub) {
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


