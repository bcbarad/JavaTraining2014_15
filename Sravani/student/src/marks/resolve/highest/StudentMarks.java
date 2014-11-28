package marks.resolve.highest;
import java.util.Scanner;
public class StudentMarks {
    Student[] students;
    public static void main(String[] args) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        Total t = new Total();
        System.out.println("enter no. of students");
        int nst = sc.nextInt();
        System.out.println("enter no. of subjects");
        int nsb = sc.nextInt();
        StudentMarks sm = new StudentMarks();
        int highm;
        String highname = null;
        sm.students = new Student[nst];
        for (int i = 0; i < nst; i++) {
            sm.students[i] = Student.readMe(sc,nst , nsb);
        }
        t.displayMax(nst , sm);
        t.displayIndividual(nst , nsb , sm);
    }
}
class Student {
    String name;
    public Marks[] allMarks;
    int nsb , total;
    public static Student readMe(Scanner sc , int nst , int nsb) {
        Student s = new Student();
        System.out.println("enter name of the student");
        s.name = sc.next();
        s.total = 0;
        s.allMarks = new Marks[nsb];
        for (int i =0; i < nsb; i++) {
            s.allMarks[i] = Marks.readMe(sc,nst);
            s.total += s.allMarks[i].submarks;
        }
        return s;
    }
}

class Marks {
    int submarks;
    String subname;
    public static Marks readMe(Scanner sc , int nst) {
        Marks m = new Marks();
        System.out.println("enter subname sb");
        m.subname = sc.next();
        System.out.println("enter marks m");
        m.submarks = sc.nextInt();
        return m;
    }
}
class Total{
    public static void displayMax(int stucount , StudentMarks sm) {
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
    public static void displayIndividual(int stucount , int subjects , StudentMarks sm) {
        int high = 0;
        String highname = "" , sub = "";
        for(int i = 0; i < subjects; i++) {
            high = 0;
            for(int j=0; j < stucount; j++) {
                if(high < sm.students[i].allMarks[j].submarks) {
                    high = sm.students[i].allMarks[j].submarks;
                    highname = sm.students[i].name;
                    sub = sm.students[i].allMarks[j].subname;
                }
            }
            System.out.println(highname + "got highest marks" + high + "in" + sub);
        }
    }
}

