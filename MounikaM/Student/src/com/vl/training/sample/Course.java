package com.vl.training.sample;
import java.util.Scanner;
class Marks  {
    private int marks;
    private String subject;

    public static  Marks readme(Scanner reader) {
        Marks m = new Marks();
        m.subject = reader.next();
        m.marks = reader.nextInt();
        return m;
    }
    public int getMarks() {
        return marks;
    }
    public String getSubject() {
        return subject;
    }
}


class Student {
    private  String sname;
    public Marks[] mark;
    private int total = 0;
    public static Student readme(Scanner reader, int noOfSubjects) {
        int total = 0;
        Student s = new Student();
        s.sname = reader.next();
        s.mark = new Marks[noOfSubjects];
        System.out.println("\n enetr name  of subjects and matks");
        for (int i = 0; i < noOfSubjects; i++) {
            s.mark[i] = Marks.readme(reader);
            total = total + s.mark[i].getMarks();

        }
        s.total = total;
        return  s;
    }
    public String getStudentname() {
        return sname;
    }
    public int getTotalMarks() {
        return total;
    }
}


public class Course {
    private static Student[] std;

    public static Course readme(Scanner reader, int noOfStudents, int noOfSubjects) {
        Course ce = new Course();
        ce.std = new Student[noOfStudents];
        for (int i = 0; i < noOfStudents; i++) {
            System.out.println("\n enetr student name:");
            ce.std[i] = Student.readme(reader, noOfSubjects);
        }

        return  ce;
    }
    public String  getFirstRanker(int noOfStudents) {
        int highest = 0;
        Course c = new Course();
        int count = 0;
        for (int i = 0; i < noOfStudents; i++) {
            if (highest < c.std[i].getTotalMarks()) {
                highest = c.std[i].getTotalMarks();
                count = i;
            }
        }
        return c.std[count].getStudentname();
    }
    public void getSubjectHighest(String subject, int noOfStudents, int noOfSubjects) {
        String name = null;
        Course c = new Course();
        int high = 0;
        for (int i = 0; i < noOfSubjects; i++) {
            for (int j = 0; j < noOfStudents; j++) {
                if (subject.equals(c.std[j].mark[j].getSubject())) {
                    if (high < c.std[j].mark[i].getMarks()) {
                        high = c.std[j].mark[i].getMarks();
                        name = c.std[j].getStudentname();
                    }
                }
            }
        }
        System.out.println(name + "got highest marks" + high + "in" + subject);
    }
    public static void main(String[] args)throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("\n enetr number of students:");
        int noOfStudents = sc.nextInt();
        System.out.println("\n enetr number of subject:");
        int noOfSubjects = sc.nextInt();
        Course cs = new Course();
        Course cse;
        System.out.println("\n enetr student names one after another:");
        cse = readme(sc, noOfStudents, noOfSubjects);
        System.out.println(" student who got highest marks is :");
        String sname = cs.getFirstRanker(noOfStudents);
        System.out.println("\n first ranker is: " + sname);
        System.out.println("\n enetr subject:");
        String subject = sc.next();

        cs.getSubjectHighest(subject, noOfStudents, noOfSubjects);


    }

}
