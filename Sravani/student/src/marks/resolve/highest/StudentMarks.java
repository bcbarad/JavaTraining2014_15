package marks.resolve.highest;
import java.util.Scanner;
public final class StudentMarks {
    private StudentMarks() {
    }
    private static Student[] students;
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no. of students");
        int nst = sc.nextInt();
        System.out.println("entr no.of subjects");
        int nsb = sc.nextInt();
        StudentMarks sm = new StudentMarks();
        sm.students = new Student[nst];
        for (int i = 0; i < nst; i++) {    //for entering student array details
            sm.students[i] = Student.readMe(sc , nsb);
        }
        Object o = sm.getMax(students , new StudentMaxMarks());                //to calculate total highest
        Student s = (Student) o;
        System.out.println("Student max total : " + s.total + "with name" + s.name);
        System.out.println("enter the subject");
        String subname = sc.next();
        Object o1 = sm.getMax(students , new StudentsubMaxMarks(subname));    //to calculate who got highest in particular subject
        Student s1 = (Student) o1;
        System.out.println(s1.getStudentName() + "got highest marks ");
    }
    static Object getMax(final Object[] students , final Searchable s) {
        Object max = students[0];
        for (int i = 1; i < students.length; i++) {
            if (s.match(max , students[i])) {
                max = students[i];
            }
        }
        return max;
    }
}
class Student {
    String name;
    public Marks[] allMarks;
    public int total;
    public static Student readMe(final Scanner sc , final int nsb) {
        int total1 = 0;
        Student s = new Student();
        System.out.println("enter name of the student");
        s.name = sc.next();
        s.allMarks = new Marks[nsb];
        for (int i = 0; i < nsb; i++) {
            s.allMarks[i] = Marks.readMe(sc);
            total1 += s.allMarks[i].submarks;
        }
        s.total = total1;
        return s;
    }
    public String getStudentName() {
        return name;
    }
    public int subjectMarks(final String subname) {
        int marks = 0;
        for (int j = 0; j < this.allMarks.length; j++) {
            if (subname.equals(this.allMarks[j].subname)) {
                marks = this.allMarks[j].submarks;
                break;
            }
        }
        return marks;
    }
}
class Marks {
    int submarks;
    String subname;
    static Marks readMe(final Scanner sc) {
        Marks m = new Marks();
        System.out.println("enter subname sb");
        m.subname = sc.next();
        System.out.println("enter marks m");
        m.submarks = sc.nextInt();
        return m;
    }
}
interface Searchable {
    public boolean match(Object o1 , Object  o2);
}
class StudentMaxMarks implements Searchable {
    public boolean match(Object o1 , Object o2) {
        Student std1 = (Student) o1;
        Student std2 = (Student) o2;
        if (std1.total < std2.total) {
            return true;
        } else {
            return false;
        }
    }
}
class StudentsubMaxMarks implements Searchable {
    String subname;
    public StudentsubMaxMarks(final String sub) {
        subname = sub;
    }
    public boolean match(Object o1 , Object o2) {
        Student std1 = (Student) o1;
        Student std2 = (Student) o2;
        if (std1.subjectMarks(subname) < std2.subjectMarks(subname)) {
            return true;
        } else {
            return false;
        }
    }
}

