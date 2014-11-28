import java.util.Scanner;
class Marks {
    public String subject;
    public  int mark;
    public static Marks readMe(Scanner reader) {
        Marks marks=new Marks();
        marks.subject=reader.next();
        marks.mark=reader.nextInt();
        return marks;
    }
    public  int getMarks()
    {
        return mark;
    }
}
class Student {
    String name;
    public Marks[] allMarks;
    public int total=0;
    public static Student readMe(Scanner reader,int subcount) {
        Student s=new Student();
        System.out.println("enter the student name");
        s.name=reader.next();
        s.allMarks=new Marks[subcount];
        int total=0;
        System.out.println("enter the subjects and marks");
        for( int i= 0; i < subcount; i++) {
            s.allMarks[i] = Marks.readMe(reader);
            total = total +s.allMarks[i].getMarks();
        }
        s.total = total;
        return s;
    }
    public String readString() {
        return name;
    }
    public int getTotalMarks() {
        return total;
    }
}
class Course {
    private static Student[] allStudents;
    public static String firstRanker(int studcount) {
        int highest = 0;
        Course c = new Course();
        int count = 0;
        for (int i = 0; i< studcount ; i++ ) {
            if ( highest < c.allStudents[i].total){
                highest = c.allStudents[i].total;
                count = i;
            }
        }
        return c.allStudents[count].name;
    }
    public static void high(Scanner sc,int studcount,int subcount) {
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
    }
        public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no.of students");
        int studcount=sc.nextInt();
        System.out.println("enter the no.of subjects");
        int subcount=sc.nextInt();
        Course cs=new Course();
        cs.allStudents=new Student[studcount];
        for(int i=0;i<studcount;i++) {
        cs.allStudents[i]=Student.readMe(sc,subcount);
        }
        String name = cs.firstRanker(studcount);
        System.out.println(" student who got highest total is :" + name);
        cs.high(sc,studcount,subcount);
    }
}
