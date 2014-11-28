import java.util.Scanner;
public class College {
       
               public static void main(String []args) {
               Course s=Course.readMe();
               }
}

class Course {  
     static Student []allStudents;
     //static int []totalMarks;
     static Scanner scn=new Scanner(System.in);
     static {
     System.out.println("enter no.of students:");
     }
     static int numStudents=scn.nextInt();
     public static Course readMe() {
         Course c=new Course();
         int []totalMarks=new int[c.numStudents];
         allStudents=new Student[c.numStudents];
         int max=0;
         String maxStudent="";
         for(int i=0;i<c.numStudents;i++) {
             c.allStudents[i]=Student.readMe();
         }
         System.out.println(" StName \t SubName \t Marks");
         for(int j=0;j<c.numStudents;j++) {
               System.out.println(c.allStudents[j].studentName);
               for(int k=0;k<Student.numSubjs;k++) {
                     System.out.println("\t\t"+c.allStudents[j].allScores[k].subName+"\t\t"+c.allStudents[j].allScores[k].marks);
               }
         }
         System.out.println("=============================================================================================================================================");     
         System.out.println(" StName \t  Marks");
         for(int l=0;l<c.numStudents;l++) {
               for(int m=0;m<Student.numSubjs-1;m++) {
                     totalMarks[l]=c.allStudents[l].allScores[m].marks+c.allStudents[l].allScores[m+1].marks;
                     System.out.println(c.allStudents[l].studentName+"  \t\t "+totalMarks[l]);
               }
        //System.out.println("=============================================================================================================================================");   
               max=totalMarks[0];
               if(max<=totalMarks[l]) {
                   max=totalMarks[l];
                   maxStudent=c.allStudents[l].studentName;
               }
           }
           System.out.println("The highest total marks :   "+max + "secured by   :"+maxStudent);

           return c;
     }
      
}

class Student {
   String studentName;
   Score[] allScores;
   static Scanner scn=new Scanner(System.in);
   static {
       System.out.println("Enter No of subjects:"); 
   }
   static int numSubjs=scn.nextInt();

   public static Student readMe() {
        Student s=new Student();
        System.out.println("Enter student details");
        String details=scn.nextLine();
        System.out.println("Enter student name:");
        s.studentName=scn.nextLine();
        s.allScores=new Score[s.numSubjs];
        for(int i=0;i<s.numSubjs;i++) {
            s.allScores[i]=Score.readMe();
        }
        
        return s;

   }



}

class Score {
    public String subName;
    public int marks;
    public static Score readMe() {
        Scanner scn=new Scanner(System.in);
         System.out.println("Enter sub name:");
         String curSub=scn.nextLine();
        System.out.println("Enter marks");
        int curMarks=scn.nextInt();
      Score sc=new Score();
      sc.subName=curSub;
      sc.marks=curMarks;
      return sc;
   
    } 


}
