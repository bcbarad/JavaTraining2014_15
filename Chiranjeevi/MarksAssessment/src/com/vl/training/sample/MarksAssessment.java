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
        //Getting the TotalMax Details
        MaximumTotalFinder  maxTotalFinder = new MaximumTotalFinder();
        Value maxTotal = getMaximum(student, maxTotalFinder);
        System.out.println("Maximum marks are scored by " + maxTotal.getName() + "with marks: " + maxTotal.getMarks());
        //Getting the Details of the student who got maximum marks in a particular subject
        SubjectMaximumFinder subMaximumFinder = new SubjectMaximumFinder();
        String subject = sc.next();
        subMaximumFinder.sub = subject;
        Value subjectMax = getMaximum(student, subMaximumFinder);
        System.out.println("Maximum marks in " + subject + " is obtained by " + subjectMax.getName() + "with marks: " + subjectMax.getMarks());
    }

    public static Value getMaximum(Object[] object, Searchable search) {
        Value value = search.getMax(object);
        return value;
        }
}

class Value {
    private String name;
    private int marks;

    Value(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    int getMarks() {
        return marks;
    }

    String getName() {
        return name;
    }
}

interface Searchable {

    Value getMax(Object[] x);
}

class MaximumTotalFinder implements Searchable {

    public Value getMax(Object[] x) {
        int maxTotal = 0, temp = 0;
        String maxStudent = "";
        Student max = (Student) x[0];
        for (int i=0; i< x.length; i++) {
            temp = ((Student)x[i]).getTotal();
            if (maxTotal< temp) {
                maxTotal = temp;
                maxStudent = ((Student)x[i]).getName();
            }
        }
        return new Value(maxStudent, maxTotal);
    }
}

class SubjectMaximumFinder implements Searchable {
    String sub="";

    public Value getMax(Object[] x) {
        String name="";
        int max=0,temp=0;
        //Code to find the subject maximum details
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < ((Student) x[i]).subject.length; j++) {
                if ((sub).equals(((Student) x[i]).subject[j].getSubjectName())) {
                    temp = ((Student) x[i]).subject[j].getMarks();
                    if(max < temp) {
                        max = temp;
                        name = ((Student) x[i]).getName();
                    }
                }
            }
        }
        Value value = new Value(name, max);
        return value;
    }
}

class Student {
    String name;
    int total;
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
        for (Subject i : subject)
             total += i.getMarks();
        return total;
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
