package com.vl.training.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MarksAssessment {
    static Student[] student;
    static int n;

    public static void main(final String arr[]) throws FileNotFoundException {
        //Enter the no. of Students
        Scanner sc = new Scanner(new File(arr[0]));
        n = sc.nextInt();
        student = new Student[n];
        for (int i = 0; i < n; i++) {
            student[i] = new Student().readMe(sc);
        }
        //Getting the TotalMax Details
        System.out.println("Maximum marks are scored by "+totalMaximum());
        //Getting the Details of the student who got maximum marks in a particular subject
        String subject = sc.next();
        System.out.println("Maximum marks in " + subject + " is obtained by " + subjectMaximum(subject));
    }
    
    public static String totalMaximum() {
        int maxMarks=0;
        String maxStudent = "";
        for (int i = 0; i < n; i++) {
            int temp = student[i].getTotal();
            if (maxMarks < temp) {
                maxMarks = temp;
                maxStudent = student[i].getName();
            }
        }
        return maxStudent + " " +maxMarks;
    }

    public static String subjectMaximum(String sub) {
        String name="";
        int max=0,temp=0;
        //Code to find the subject maximum details
        for (int i = 0; i < n; i++) {
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
        return name + " with marks: " + max;
    }
}

class Student {
    String name;
    int total;
    Subject[] subject;

    Student readMe(Scanner sc) {

        Student student = new Student();
        //Reading the name
        student.name = sc.next();
        //Reading the no. of subjects
        int n = sc.nextInt();
        student.subject = new Subject[n];
        for (int i = 0; i < n; i++){
             student.subject[i] = new Subject().readMe(sc);
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

    Subject readMe(Scanner sc) {
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
