package com.vl.training.sample;
import java.util.Scanner;
interface Searchable {
    public int match(Object o1,Object o2);
}
class StudentMax implements Searchable {
    public int match(Object obj1,Object obj2) {
        Student s1=(Student)obj1;
        Student s2=(Student)obj2;
        if (s1.total1 > s2.total1) {
            return 1;
        }
        return 0;    
    }
}
public final class StudData {
    private StudData() {
    }
    public static void main(final String []args) {
        Scanner sc = new Scanner(System.in);
        Course c = new Course();
        Searchable s = new StudentMax();
        c = c.readme(sc);
        c.print();
        Object o=c.getmax(c.allstudents, new StudentMax());
        Student ss=(Student)o;
        System.out.println("student who got total highest is "+ ss.sname + "with" + ss.total1);
    }
}
class Course extends StudentMax {
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
    Object getmax(Object[] allstudents,Searchable s) {
        Object max=allstudents[0];
        for (int j=1;j<allstudents.length;j++) {
             if(s.match(max,allstudents[j])==1) { 
                 max =allstudents[j-1];          
             } else {
                 max=allstudents[j];
             }
        }
        return max;
    }    
}
class Student {
    String sname;
    int nosub;
    Marks[] allmarks;
    int total1;
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
        s.total1=total;
        System.out.println(s.total1);
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
