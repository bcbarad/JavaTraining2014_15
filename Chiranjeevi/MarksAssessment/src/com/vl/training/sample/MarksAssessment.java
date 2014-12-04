package com.vl.training.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarksAssessment {
    static Student[] student;
    static int numberOfStudents;

    public static void main(final String arr[]) throws FileNotFoundException {
        //Enter the no. of Students
        Scanner sc = new Scanner(new File(arr[0]));
        numberOfStudents = sc.nextInt();
        student = new Student[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            student[i] = Student.readMe(sc);
        }

        //Finding the Student who secured maximum Total
        MaximumTotalFinder  maxTotalFinder = new MaximumTotalFinder();
        Student maxTotal = (Student) getMaximum(student, maxTotalFinder);
        System.out.println("Maximum marks are scored by " + maxTotal.getName() + " with marks: " + maxTotal.getTotal());

        //Find the Student who secured the highest marks in a given subject
        SubjectMaximumFinder subMaximumFinder = new SubjectMaximumFinder();
        String subject = sc.next();
        subMaximumFinder.setSubject(subject);
        Student subjectMax = (Student) getMaximum(student, subMaximumFinder);
        System.out.println("Maximum marks in " + subject + " is obtained by " + subjectMax.getName() + " with marks: " + subjectMax.getMarks(subject));
    }

    public static Object getMaximum(Object[] object, Searchable search) {

        Object max = object[0];
        for(int i = 1; i < object.length; i++) {
            max = search.getMax(max, object[i]);
        }
        return max;
    }
}

interface Searchable {

    Object getMax(Object a, Object b);
}

class MaximumTotalFinder implements Searchable {

    public Object getMax(Object a, Object b) {
        Student s1 = (Student) a;
        Student s2 = (Student) b;
        int m1 = s1.getTotal();
        int m2 = s2.getTotal();
        if (m1 < m2) {
                return s2;
        }
        else {
                return s1;
        }
    }
}

class SubjectMaximumFinder implements Searchable {

    private String sub;

    public Object getMax(Object a, Object b) {
        Student s1 = (Student) a;
        Student s2 = (Student) b;
        if(s1.getMarks(sub) < s2.getMarks(sub)) {
            return s2;
        }
        else {
            return s1;
        }
    }

    public void setSubject(String subject) {
        this.sub = subject;
    }
}

class Student {
    String name;
    Subject[] subject;

    static Student readMe(Scanner sc) {

        Student student = new Student();
        //Reading the name
        student.name = sc.next();
        //Reading the no. of subjects
        int numberOfSubjects = sc.nextInt();
        student.subject = new Subject[numberOfSubjects];
        for (int i = 0; i < numberOfSubjects; i++){
             student.subject[i] = Subject.readMe(sc);
        }
        return student;
    }

    int getTotal() {
        int total =0;
        for (Subject i : subject)
             total += i.getMarks();
        return total;
    }

    int getMarks(String sub) {
        for (Subject i : subject) {
            if (sub.equals(i.getSubjectName()))
                return i.getMarks();
        }
        return -1;
    }

    String getName() {
        return name;
    }
}

class Subject {
    String name;
    int marks;

    static Subject readMe(Scanner sc) {
        Subject subject = new Subject();
        subject.name = sc.next();
        subject.marks = sc.nextInt();
     return subject;
    }

    String getSubjectName(){
        return name;
    }

    int getMarks() {
        return marks;
    }
}
