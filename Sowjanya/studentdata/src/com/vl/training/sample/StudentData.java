//package com.vl.training.sample;
import java.util.Scanner;
public class StudentData {
    private StudentData() {
    }
 public Course[] studentdata = {};
    public static void main(final String[] args) {
        int NUMBER_OF_STUDENTS = 0, NUMBER_OF_SUBJECTS = 0, i = 0;
        StudentData sd = new StudentData();
        NUMBER_OF_STUDENTS = Integer.parseInt(args[0]);
        NUMBER_OF_SUBJECTS = Integer.parseInt(args[1]);
        Course.readMe(i, NUMBER_OF_STUDENTS, NUMBER_OF_SUBJECTS);
        Print.print(NUMBER_OF_STUDENTS, NUMBER_OF_SUBJECTS);
        Highest.highest(NUMBER_OF_STUDENTS, NUMBER_OF_SUBJECTS);
        StudentName.studentname(NUMBER_OF_STUDENTS, NUMBER_OF_SUBJECTS);
    }
}
final class Course {
   Course() {
    }
    static Student[] allstudents;
    public static Course readMe(int i, final int NUMBER_OF_STUDENTS, final int NUMBER_OF_SUBJECTS) {
        Course c = new Course();
        c.allstudents = new Student[NUMBER_OF_STUDENTS];
        while (i < allstudents.length) {
            System.out.println("enter the details for the student" + i);
            c.allstudents[i] = Student.readMe(NUMBER_OF_SUBJECTS);
            i++;
        }
        return c;
    }
}
class Student {
    public String name;
    public Marks[] allmarks;
    public int  total1;
    public static Student readMe(final int NUMBER_OF_SUBJECTS) {
        int total = 0;
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the student name");
        s.name = sc.next();
        s.allmarks = new Marks[NUMBER_OF_SUBJECTS];
        for (int i = 0; i < NUMBER_OF_SUBJECTS; i++) {
            System.out.println("enter the marks details here");
            s.allmarks[i] = Marks.readMe();
            total = total + s.allmarks[i].marks;
        }
        s.total1 = total;
        return s;
    }
}
class Marks {
    public String sub;
    public int marks;
    public static Marks readMe() {
        Marks m = new Marks();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the subject name");
        m.sub = sc.next();
        System.out.println("enter the " + m.sub + "marks");
        m.marks = sc.nextInt();
        return m;
    }
}
final class Print {
      public static void print(int NUMBER_OF_STUDENTS,int NUMBER_OF_SUBJECTS) {
      int j,k;
Course c = new Course();
   //System.out.println("name     subject     marks");
           for (j = 0; j < NUMBER_OF_STUDENTS; j++) {
            System.out.print(c.allstudents[j].name);
            for (k = 0; k < NUMBER_OF_SUBJECTS; k++) 
                if (NUMBER_OF_SUBJECTS >= 1) 
                    System.out.println("\t" + c.allstudents[j].allmarks[k].sub + "\t" + c.allstudents[j].allmarks[k].marks + "\t");
            }   
             
        }
}
final class Highest {
        static int highest = 0;
        static String name = "";
    public static void highest(int NUMBER_OF_STUDENTS,int NUMBER_OF_SUBJECTS) {
Course c = new Course();
        for (int p = 0; p < NUMBER_OF_SUBJECTS; p++) {
            if (c.allstudents[p].total1 > highest) {
                highest = c.allstudents[p].total1;
                name = c.allstudents[p].name;
       System.out.println("student who got high total marks is" + name);
        }
    }
  }
}
final class StudentName
{
       // System.out.println("student who got high total marks is" + name);
        static String indname = " ";
public static void studentname(int NUMBER_OF_STUDENTS,int NUMBER_OF_SUBJECTS)
{
        for (int q = 0; q < NUMBER_OF_SUBJECTS; q++) {
            int highestmarks = 0;
Course c = new Course();
            for (int r = 0; r < NUMBER_OF_STUDENTS; r++) {
                if (c.allstudents[r].allmarks[q].marks > highestmarks) {
                    highestmarks = c.allstudents[r].allmarks[q].marks;
                    indname = c.allstudents[r].name;
                }
            }
            System.out.println(indname + " got higest marks of " + highestmarks + "  in " + c.allstudents[q].allmarks[q].sub);
        }
     }
}
