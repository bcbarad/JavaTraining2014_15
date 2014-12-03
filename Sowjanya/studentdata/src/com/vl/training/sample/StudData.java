package com.vl.training.sample;
import java.util.Scanner;
interface Searchable {
    void stuhightotal(Course c);
    void high(Scanner sc,Course c); 
} 
abstract class SearchableBase implements Searchable {
    public void stuhightotal(Course c) {
        int highest = 0;
        String name = " ";
        for (int i = 0; i < c.nostud; i++) {
            for (int j = 0; j < c.allstudents[i].allmarks.length; j++) {
                if (c.allstudents[i].total1 > highest) {
                    highest = c.allstudents[i].total1;
                    name = c.allstudents[i].sname;
                }
            }
        }
        System.out.println("student who got high total marks is" + name);
    }
     public void high(final Scanner sc,Course c) {
        System.out.println("enter the subject name");
        String subname = sc.next();
        String name = " ";
        int marks = 0, highest = 0;
        for (int i = 0; i < c.allstudents.length; i++) {
            for (int j = 0; j < c.allstudents[i].allmarks.length; j++) {
                if ((subname).equals(c.allstudents[i].allmarks[j].subname)) {
                    marks = c.allstudents[i].allmarks[j].submarks;
                    if (highest < marks) {
                        highest = marks;
                        name = c.allstudents[i].sname;
                    }
                }
            }
        }
        System.out.println(name + " got highest marks in" + subname);
    }
}
public final class StudData {
    private StudData() {
    }
    public static void main(final String []args) {
        Scanner sc = new Scanner(System.in);
        Course c = new Course();
        c = c.readme(sc);
        c.print();
        c.stuhightotal(c);
        c.high(sc,c);
    }
}
class Course extends SearchableBase{
    int nostud;
    Student[] allstudents;
    public static Course readme(final Scanner sc) {
        Course c = new Course();
        System.out.println("enter the numberof students");
        c.nostud = sc.nextInt();
        c.allstudents = new Student[c.nostud];
        for (int i = 0; i < c.allstudents.length; i++) {
            c.allstudents[i] = Student.readme(sc);
        }
        return c;
    }
    public void print() {
        System.out.println("name     subject     marks");
        for (int i = 0; i < nostud; i++) {
            System.out.print(allstudents[i].sname);
            for (int j = 0; j < allstudents[i].allmarks.length; j++) {
                System.out.println("\t" + allstudents[i].allmarks[j].subname + "\t" + allstudents[i].allmarks[j].submarks + "\t" + allstudents[i].total1);
               
            }
        }
    }
    //public void stuhightotal(Course c);
    /*public void stuhightotal() {
       int highest = 0;
        String name = " ";
        for (int i = 0; i < nostud; i++) {
            for (int j = 0; j < allstudents[i].allmarks.length; j++) {
                if (allstudents[i].total1 > highest) {
                    highest = allstudents[i].total1;
                    name = allstudents[i].sname;
                }
            }
        }
        System.out.println("student who got high total marks is" + name);
    }*/
    /*public void high(final Scanner sc) {
        System.out.println("enter the subject name");
        String subname = sc.next();
        String name = " ";
        int marks = 0, highest = 0;
        for (int i = 0; i < allstudents.length; i++) {
            for (int j = 0; j < allstudents[i].allmarks.length; j++) {
                if ((subname).equals(allstudents[i].allmarks[j].subname)) {
                    marks = allstudents[i].allmarks[j].submarks;
                    if (highest < marks) {
                        highest = marks;
                        name = allstudents[i].sname;
                    }
                }
            }
        }
        System.out.println(name + " got highest marks in" + subname);
    }*/
}
class Student {
    String sname;
    int nosub;
    Marks[] allmarks;
    int  total1;
    public static Student readme(final Scanner sc) {
        Student s = new Student();
        int total = 0;
        Marks m = new Marks();
        System.out.println("enter the student name:");
        s.sname = sc.next();
        System.out.println("enter the number of subjects");
        s.nosub = sc.nextInt();
        s.allmarks = new Marks[s.nosub];
        for (int i = 0; i < s.nosub; i++) {
            s.allmarks[i] = Marks.readme(sc);
            total = total + s.allmarks[i].submarks;
        }
        s.total1 = total;
        return s;
    }
}
class Marks {
    String subname;
    int submarks;
    static Marks readme(final Scanner sc) {
        Marks m = new Marks();
        System.out.println("enter the subject name");
        m.subname = sc.next();
        System.out.println("enter the subject marks");
        m.submarks = sc.nextInt();
        return m;
    }
}
