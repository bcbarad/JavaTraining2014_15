//package com.vl.training.sample;
import java.util.Scanner;
public class StudentMarks {
    private Student[] allstudents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter no of students:");
        int stucount = sc.nextInt();
        System.out.println(" enter no of subjects:");
        int subcount = sc.nextInt();
        StudentMarks sm = new StudentMarks();
        sm.allstudents = new Student[stucount + 1];
        for (int i = 1; i <= stucount; i++) {
            sm.allstudents[i] = Student.readMe(subcount , i , new Scanner(System.in));
        } 
        StudentMarks.displayMax(stucount , sm);
        StudentMarks.displayIndiviSub(subcount , stucount , sm);   
    }   
    public static void displayMax(int stucount , StudentMarks sm) {
        int high = 0;
        String highname = "";
        for (int i = 1; i <= stucount; i++) {  
           if (sm.allstudents[i].total1 > high) {
                high = sm.allstudents[i].total1;
                highname = sm.allstudents[i].name;
            }
        }
        System.out.println("the student who got highest marks is: " + highname + " and marks: " + high);
    }
    public static void displayIndiviSub(int subcount ,int stucount , StudentMarks sm) {
        System.out.println("----------Individual subject high marks ------------"); 
        System.out.println(" SUBJECT     NAME      MARKS  ");
        String subhighname = " ";
        for (int i = 1; i <= subcount; i++) {
            int subhigh = 0;
            for (int j = 1; j <= stucount; j++) {
                if (sm.allstudents[j].allMarks[i].marks > subhigh) {
                    subhigh = sm.allstudents[j].allMarks[i].marks;
                    subhighname = sm.allstudents[j].name;
                }
            }
            System.out.println(sm.allstudents[i].allMarks[i].subject + "     " + subhighname + "       " + subhigh);
        }
    }
}
class Student {
    public String name;
    public Marks[] allMarks;
    public int  total1;
    public static  Student readMe(int subcount , int i , Scanner sc) {    // read the name of student and move to get the sujects and marks
        int total = 0;
        Student ss = new Student();
        System.out.println(" enter student" + i + " name: ");
        ss.name = sc.nextLine();
        ss.allMarks = new Marks[subcount + 1];
        for (int j = 1; j <= subcount; j++) {
            ss.allMarks[j] = Marks.readMe(j , new Scanner(System.in));
            total += ss.allMarks[j].marks;
        }
        ss.total1 = total;
        return ss;
    }
}

class Marks {
    public String subject;
    public int marks;
    public static  Marks readMe(int j , Scanner sc) {  //  read the subjects and the marks
        Marks mm = new Marks();
        System.out.println(" enter subject" + j + ": ");
        mm.subject = sc.nextLine();
        System.out.println(" enter subject" + j + " marks:");
        mm.marks = sc.nextInt();
        return mm;     // returns the Marks object to student class
    }
}

