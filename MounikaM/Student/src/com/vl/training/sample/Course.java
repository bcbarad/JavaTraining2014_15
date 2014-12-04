package com.vl.training.sample;
import java.util.Scanner;
import java.io.File;

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
    public static Student readme(Scanner reader, int noOfSubjects) {  // to read Number of subject and respective marks in each subject for  students
        int total = 0;
        Student s = new Student();
        s.sname = reader.next();
        s.mark = new Marks[noOfSubjects];
        // System.out.println("\n enetr name  of subjects and matks");
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
    public int getMarksOfSubject(String subject) { // to get marks for particular subject
        int marks = 0;
        for (int i = 0; i < mark.length; i++) {
            if (subject.equals(mark[i].getSubject())) {
                marks = mark[i].getMarks();
            }
        }
        return marks;
    }
}


public class Course {
    public static Student[] std;
    private static int noOfStudents;
    private static int noOfSubjects;

    public static Course readme(Scanner reader) {
        Course ce = new Course();
        ce.std = new Student[noOfStudents];
        for (int i = 0; i < noOfStudents; i++) {
            //    System.out.println("\n enetr student name:");
            ce.std[i] = Student.readme(reader, noOfSubjects);
        }

        return  ce;
    }
    public static void main(String[] args)throws Exception {

        Scanner sc = new Scanner(new File("../student.txt"));
        Course cs = new Course();
        // System.out.println("\n enetr number of students:");
        noOfStudents = sc.nextInt();
        // System.out.println("\n enetr number of subject:");
        noOfSubjects = sc.nextInt();
        Course cse;
        //  System.out.println("\n enetr student names one after another:");
        cse = readme(sc);
       //  System.out.println(" student who got highest marks is :");
        Object student = getMax(std, new StudentTotalMaximum());
        Student s = (Student) student;
        System.out.println(s.getStudentname());
        //  System.out.println("\n enter subject :");
        Object so = getMax(std, new StudentSubjectWiseMaximum("maths"));
        Student st = (Student) so;
        System.out.println(st.getStudentname());
    }

    public static Object getMax(Object[] obj, StudentInterface si) {
        Object max = obj[0];
        for (int i = 1; i < obj.length; i++) {
            if (si.match(max, obj[i])) {
                max = obj[i];
            }
        }
        return max;
    }
}

interface StudentInterface {
    // checks obj1 and obj2 if obj1>obj2 return true
    // if obj1<obj2 return false
    public boolean match(Object obj1, Object obj2);
}

class StudentTotalMaximum implements StudentInterface {
    public boolean match(Object obj1, Object obj2) {
        Student std1 = (Student) obj1;
        Student std2 = (Student) obj2;

        if (std1.getTotalMarks() < std2.getTotalMarks()) {
            return true;
        } else {
            return false;
        }
    }
}

class StudentSubjectWiseMaximum implements StudentInterface {
    private String subject;
    public StudentSubjectWiseMaximum(final String sub) {
        this.subject = sub;
    }
    public boolean match(Object obj1, Object obj2) {
        Student std1 = (Student) obj1;
        Student std2 = (Student) obj2;

        if (std1.getMarksOfSubject(subject) < std2.getMarksOfSubject(subject)) {
            return true;
        } else {
            return false;
        }
    }
}

