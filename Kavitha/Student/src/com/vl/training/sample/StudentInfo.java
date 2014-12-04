package com.vl.training.sample;
import java.io.*;
import java.util.Scanner;

interface Searchable {
    boolean maximum(Object o1, Object o2); 
}

class Totmax implements Searchable {
    public boolean maximum(Object o1, Object o2) {
        int count = 0;
        Student s1 = new Student();
        Student s2 = new Student();
        s1 = (Student)o1;
        s2 = (Student)o2;
        if(s1.total > s2.total) {
            return true;
        }
        else {
            return false;
        }
    }
}

class SubjectMax implements Searchable {
    String subject = "";
    public SubjectMax(String subject) {
        this.subject = subject;
    }
    public boolean maximum(Object o1, Object o2) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1 = (Student)o1;
        s2 = (Student)o2;
        if(s1.getMarks(subject) > s2.getMarks(subject)) {
            return true;
        } else {
            return false;
        }
    }
}

class StudentInfo {
    public static void main(final String []args) {
        Scanner scn = new Scanner(System.in);
	Course c = Course.readMe(scn);
	Course.display(c);
        SubjectMax s = new SubjectMax("Java");
        Object obj1 = c.getMax(c.allStudents, new Totmax());
        Student std1 = (Student)obj1;
        System.out.println("The highest total is : " + std1.total +  "  Secured by : " + std1.studentName);
        Object obj2 = c.getMax(c.allStudents, s);
        Student std2 = (Student)obj1;
        System.out.println("The highest marks is: " + std2.marks + " Secured by: " + std2.studentName);
    }
        
}
class Course {
    static int numStudents; 
    Student []allStudents;
    static Course readMe(final Scanner scn) {
        Course c = new Course();   
	System.out.println("Enter no. of students:");
	numStudents = scn.nextInt();
	c.allStudents = new Student[numStudents];
	for (int i = 0; i < numStudents; i++) {
	    c.allStudents[ i ] = Student.readMe(scn);
	}
	return c; 
    }
    static void display(final Course c) {
        System.out.println(" StName \t SubName \t Marks");
	for (int j = 0; j < c.numStudents; j++) {
	    System.out.println(c.allStudents[ j ].studentName);
	    for (int k = 0; k < Student.numSubjs; k++) {
	        System.out.println("\t\t" + c.allStudents[ j ].allScores[ k ].subName + "\t\t" + c.allStudents[ j ].allScores[ k ].marks);
	    }
	}
}   
    Object getMax(Object []allObjects, Searchable s) {
        Object max = allObjects[0];
        int maxTotal = 0, temp = 0;
        boolean greater;
        for(int i=0;i<allObjects.length;i++) {
        greater = s.maximum(allObjects[i], max);
            if(greater){
                max = allObjects[i];
            }
        }
        return max;
    }
}

class Student {
    String studentName;
    Score[] allScores;
    static Scanner scn = new Scanner(System.in);
    static int numSubjs;
    public int totalMarks = 0;
    public int total;
    int marks = 0;
    static Student readMe(final Scanner scn) {
        Student s = new Student();
	System.out.println("Enter No of subjects:"); 
        numSubjs = scn.nextInt();
        System.out.println("Enter student details");
	String details = scn.nextLine();
	System.out.println("Enter student name:");
	s.studentName = scn.nextLine();
	s.allScores = new Score[ s.numSubjs ];
	for (int i = 0; i < s.numSubjs; i++) {
	    s.allScores[ i ] = Score.readMe();
            s.totalMarks = s.totalMarks + s.allScores[i].marks;
	}
        s.total = s.totalMarks;
        return s;
    }
    int getMarks(String sName) {
        
        for(int i = 0; i<allScores.length; i++) {
            if(sName.equals(allScores[ i ].subName))
                marks = allScores[i].marks;
        }
        return marks;
    }
}

class Score {
    String subName;
    int marks;
    static Score readMe() {
        Scanner scn = new Scanner(System.in);
	System.out.println("Enter sub name:");
	String curSub = scn.nextLine();
	System.out.println("Enter marks");
	int curMarks = scn.nextInt();
	Score sc = new Score();
	sc.subName = curSub;
	sc.marks = curMarks;
	return sc;
    }
}
