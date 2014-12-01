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
        Value maxTotal = getMaximumTotal();
        System.out.println("Maximum marks are scored by " + maxTotal.getName() + "with marks: " + maxTotal.getMarks());
        //Getting the Details of the student who got maximum marks in a particular subject
        String subject = sc.next();
        Value subjectMax = subjectMaximum(subject);
        System.out.println("Maximum marks in " + subject + " is obtained by " + subjectMax.getName() + "with marks: " + subjectMax.getMarks());
    }
    
    public static Value getMaximumTotal() {
        int maxMarks=0;
        String maxStudent = "";
        for (int i = 0; i < numberOfStudents; i++) {
            int temp = student[i].getTotal();
            if (maxMarks < temp) {
                maxMarks = temp;
                maxStudent = student[i].getName();
            }
        }
        Value value = new Value(maxStudent, maxMarks);
        return value;
    }

    public static Value subjectMaximum(String sub) {
        String name="";
        int max=0,temp=0;
        
        //Code to find the subject maximum details
        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < student[i].subject.length; j++) {
                if ((sub).equals(student[i].subject[j].getSubjectName())) {
                    temp = student[i].subject[j].getMarks();
                    if(max < temp) {
                        max = temp;
                        name = student[i].getName();
                    }                   
                }
            }
        }
        Value value = new Value(name, max);
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
