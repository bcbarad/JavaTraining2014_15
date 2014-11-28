import java.util.Scanner;
class Marks{
    private String subject;
    private int mark;

    public static Marks readMe(Scanner reader){
        Marks marks=new Marks();
        marks.subject=reader.next();
        marks.mark=reader.nextInt();
        return marks;
    }
    public int getMarks()
    {
        return mark;
    }
}
class Student{
    String name;
    private Marks[] allMarks;
    public int total=0;
    public static Student readMe(Scanner reader,int subcount){
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
    public String readString(){
        return name;
    }
    public int getTotalMarks(){
        return total; 
    } 
}
class Course{
    private static Student[] allStudents;
    public static Course readMe(Scanner reader,int studcount)
    {
        Course course=new Course();  
        course.allStudents=new Student[studcount];
        System.out.println("enter the no.of subjects");
        int subcount=reader.nextInt();
        for(int i=0;i<studcount;i++)
        {
            course.allStudents[i] = Student.readMe(reader,subcount);
        }
        return course;
    }
    public String firstRank(int studcount) {
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
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Course c=new Course();
        System.out.println("enter the no.of students");
        int studcount=sc.nextInt();
        Course cs;
        cs=readMe(sc,studcount); 
        String name = c.firstRank(studcount);
        System.out.println(" student who got highest total is :" + name);
    } 
}  
