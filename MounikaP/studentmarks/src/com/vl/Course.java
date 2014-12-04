package com.vl;
import java.util.Scanner;
interface Searchable {
    public boolean match(Object obj1, Object obj2);
}
class Marks {
    private String subject;
    private static int mark;
    static Marks readMe(final Scanner reader) {
        Marks marks = new Marks();
        System.out.println("enter the subject");
        marks.subject = reader.next();
        System.out.println("enter the marks");
        marks.mark = reader.nextInt();
        return marks;
    }
    public int getMarks() {
        return mark;
    }
    public String getSubject() {
        return subject;
    }
}
class Student {
    private String name;
    private Marks[] allMarks;
    public int total1 = 0;
    static Student readMe(final Scanner reader, final int subcount) {
        Student s = new Student();
        System.out.println("enter the student name");
        s.name = reader.next();
        s.allMarks = new Marks[subcount];
        int total = 0;
        for (int i = 0; i < subcount; i++) {
            s.allMarks[i] = Marks.readMe(reader);
            total = total + s.allMarks[i].getMarks();
        }
        s.total1 = total;
        return s;
    }
    public int getMarksOfSub(final String subject) {
        int count = 0;
        for (int i = 0; i < allMarks.length; i++) {
            if (subject.equals(allMarks[i])) {
                count = allMarks[i].getMarks();
            }
        }
        return count;
    }
    public String getName() {
        return name;
    }
}
class stdMaxMarksSearch implements Searchable {
    public boolean match(final Object obj1, final Object obj2) {
        Student std1 = (Student) obj1;
        Student std2 = (Student) obj2;
        if ((std1.total1 < std2.total1)) {
            return true;
        } else {
            return false;
        }
    }
}
class subWiseStdMarks implements Searchable {
    static String subject;
    public subWiseStdMarks(final String subject) {
        this.subject = subject;
    }
    public boolean match(final Object obj1, final Object obj2) {
        Student std1 = (Student) obj1;
        Student std2 = (Student) obj2;
        if (std1.getMarksOfSub(subject) < std2.getMarksOfSub(subject)) {
            return false;
        } else {
            return true;
        }
    }
}
public class Course  {
    private static Student[] allStudents;
    public static int studcount;
    public static int subcount;
    static Object getMax(final Object[] allStudents, final Searchable s) {
        Object max = allStudents[0];
        for (int i = 1; i < allStudents.length; i++) {
            if (s.match(max, allStudents[i]))
                max = allStudents[i];
        }
        return max;
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no.of students");
        int studcount = sc.nextInt();
        System.out.println("enter the no.of subjects");
        int subcount = sc.nextInt();
        Course cs = new Course();
        cs.allStudents = new Student[studcount];
        for (int i = 0; i < studcount; i++) {
            cs.allStudents[i] = Student.readMe(sc, subcount);
        }
        Object o = getMax(allStudents, new  stdMaxMarksSearch());
        Student s = (Student) o;
        System.out.println(s.total1);
        Object o1 = getMax(allStudents, new subWiseStdMarks("java"));
        Student s1 = (Student) o1;
        System.out.println(s1.getName());
    }
}
