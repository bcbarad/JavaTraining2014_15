import java.util.Scanner;
interface Searchable {
    int  match(Object obj1, Object obj2);
}
class Marks {
    public String subject;
    public static int mark;
    public static Marks readMe(Scanner reader) {
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
}
class Student {
    String name;
    public Marks[] allMarks;
    public int total1 = 0;
    public static Student readMe(Scanner reader, int subcount) {
        Student s = new Student();
        System.out.println("enter the student name");
        s.name = reader.next();
        s.allMarks = new Marks[subcount];
        int total = 0;
        for (int i= 0; i < subcount; i++) {
            s.allMarks[i] = Marks.readMe(reader);
            total = total +s.allMarks[i].getMarks();
        }
        s.total1 = total;
        return s;
    }
}
class stdMaxMarksSearch implements Searchable {
    public int match(Object obj1, Object obj2) {
        Student std1 = (Student)obj1;
        Student std2 = (Student)obj2;
        if ((std1.total1 < std2.total1)) {
            return -1;
        } else {
            return 0;
        }
    }
}
/*class subWiseStdMarks implements Searchable {
    String subject;
    public void search(Object obj1, Object obj2) {
        Student std1 = (Student)obj1;
        Student std2 = (Student)obj2;
        if (std1.getMarks(subject) > std2.getMarks(subject)) {
            return 0;
        } else {
            return -1;
        }
    }
}*/
class Course  {
    private static Student[] allStudents;
    public static int studcount;
    public static int subcount;
    static Object getMax(Object[] allStudents, Searchable s) {
        Object max = allStudents[0];
        for (int i = 1; i < allStudents.length; i++) {
            if (s.match(max, allStudents[i]) < 0)
                max = allStudents[i];
        }
            return max;
    }
    /*public static void subhigh(Scanner sc,int studcount,int subcount) {
        Course cs=new Course();
        int highest=0;
        String name=" ";
        for(int i=0;i<subcount;i++) {
            highest=0;
            for(int j=0;j<studcount;j++) {
                if(highest<cs.allStudents[j].allMarks[i].getMarks()) {
                    highest=cs.allStudents[j].allMarks[i].getMarks();
                    name=cs.allStudents[j].name;
                }
            }
            System.out.println("-----"+cs.allStudents[i].allMarks[i].subject+" ----"+name+ "---" + highest );
        }
    }*/
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no.of students");
        int studcount = sc.nextInt();
        System.out.println("enter the no.of subjects");
        int subcount = sc.nextInt();
        Course cs = new Course();
        cs.allStudents = new Student[studcount];
        for (int i = 0; i < studcount; i++) {
        cs.allStudents[i] = Student.readMe(sc,subcount);
        }
        Object o = getMax(allStudents, new  stdMaxMarksSearch());
        Student s = (Student)o;
        System.out.println(s.total1);
    }
}
