package marks.resolve.highest;
import java.util.Scanner;
public final class StudentMarks {
    private StudentMarks() {
    }
    private Student[] students;
    public static void main(final String[] args) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no. of students");
        int nst = sc.nextInt();
        System.out.println("enter no. of subjects");
        int nsb = sc.nextInt();
        StudentMarks sm = new StudentMarks();
        sm.students = new Student[nst];
        for (int i = 0; i < nst; i++) {
            sm.students[i] = Student.readMe(sc , nsb);
        }
        sm.displayMax(nst , sm);
        sm.displayIndividual(nst , nsb , sm);
    }
    public static void displayMax(final int stucount , final StudentMarks sm) {
        int high = 0;
        String highname = "";
        for (int i = 0; i < stucount; i++) {
            if (high < sm.students[i].total) {
                high = sm.students[i].total;
                highname = sm.students[i].name;
            }
        }
        System.out.println("student got highest marks is" + highname + " and marks: " + high);
    }
    public static void displayIndividual(final int stucount , final int subjects , final StudentMarks sm) {
        int high = 0;
        String highname = "" , sub = "";
        for (int i = 0; i < stucount; i++) {
            high = 0;
            for (int j = 0; j < subjects; j++)  {
                if (high < sm.students[i].allMarks[j].submarks) {
                    high =  sm.students[i].allMarks[j].submarks;
                    highname = sm.students[i].name;
                    sub = sm.students[i].allMarks[j].subname;
                }
            }
        }
        System.out.println(highname + "got highest marks" + high + "in" + sub);
    }
}
class Student {
    String name;
    public Marks[] allMarks;
    int nsb , total;
    public static Student readMe(final Scanner sc , final int nsb) {
        Student s = new Student();
        System.out.println("enter name of the student");
        s.name = sc.next();
        s.total = 0;
        s.allMarks = new Marks[nsb];
        for (int i = 0; i < nsb; i++) {
            s.allMarks[i] = Marks.readMe(sc);
            s.total += s.allMarks[i].submarks;
        }
        return s;
    }
}
class Marks {
    int submarks;
    String subname;
    public static Marks readMe(final Scanner sc) {
        Marks m = new Marks();
        System.out.println("enter subname sb");
        m.subname = sc.next();
        System.out.println("enter marks m");
        m.submarks = sc.nextInt();
        return m;
    }
}
