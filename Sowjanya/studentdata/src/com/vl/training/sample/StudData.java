package com.vl.training.sample;
import java.util.Scanner;
interface FindsMax {
    int match(Object o1 , Object o2);
}
class StudentMax implements FindsMax {
    public int match(final Object obj1 , final Object obj2) {
        Student s1 = (Student) obj1;
        Student s2 = (Student) obj2;
        if (s1.total1 < s2.total1) {
            return -1;
        }
        return 1;
    }
}
class SubMax implements FindsMax {
    String subject;
    public SubMax(final String subject) {
        this.subject = subject;
    }
    public int match(final Object obj1 , final Object obj2) {
        Student s1 = (Student) obj1;
        Student s2 = (Student) obj2;
        if (s1.getSubMarks(subject) < s2.getSubMarks(subject)) {
            return -1;
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
        FindsMax fm = new StudentMax();
        c = c.readme(sc);
        c.print();
        Object o = c.getmax(c.allstudents , fm);
        Student ss = (Student) o;
        System.out.println("student who got total highest is " + ss.sname + "with" + ss.total1);
        Object o1 = c.getmax(c.allstudents , new SubMax(sc.next()));
        Student ss1 = (Student) o1;
        System.out.println("student" + ss1.sname);
    }
}
class Course {
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
            System.out.print(allstudents[i].getName());
            for (int j = 0; j < allstudents[i].allmarks.length; j++) {
                System.out.println("\t" + allstudents[i].allmarks[j].getSubName() + "\t" + allstudents[i].allmarks[j].getMarks() + "\t" + allstudents[i].total1);
            }
        }
    }
    Object getmax(final Object[] allobjects , final FindsMax fm) {
        Object max = allobjects[0];
        for (int j = 1; j < allobjects.length; j++) {
            if (fm.match(max , allobjects[j]) < 0) {
                max = allobjects[j];          
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
        s.total1 = total;
        System.out.println(s.total1);
        return s;
    }
    String getName() {
        return sname;
    }
    int getSubMarks(final String sub) {
        int submarks = 0;
        for (int j = 0; j < allmarks.length; j++) {
            if ((sub).equals(allmarks[j].getSubName())) {
                submarks = allmarks[j].getMarks();
            }
        }
        return submarks;
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
    int getMarks() {
        return submarks;
    }

    String getSubName() {
        return subname;
    }
}
