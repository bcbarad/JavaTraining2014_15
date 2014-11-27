import java.util.Scanner;

/*public class Course {
      Student []students;
      System.out.println("Enter no. of students:");
      Scanner sc=new Scanner(System.in);
      int nstd=sc.nextInt();
      static Course readMe() {
          for(int i=1;i<nsub;i++) {
             Student curStd=Student.readMe();   
          }
      }


}*/
public class Abc {
  public static void Main(String []args) {
      Student.readMe();
  
  }
}


public class Student {
     
     String Name;
     
     Score []marks;
    
     Scanner sc=new Scanner(System.in);
     //System.out.println("Enter number of subjects");
     int nsub=sc.nextInt();
     static void readMe() {
                System.out.println("Enter Name");
                Scanner sc=new Scanner(System.in);
                String name=sc.nextLine(); 
                for(int i=1;i<nsub;i++) {         
                        marks[i]=Score.readMe();
                        System.out.println(marks[i]);
                   }
                //return new Student(name);
     }
}



public class Score{
     
     int marks;
     static Score readMe() {
          System.out.println("enter sub:");
          Scanner sc=new Scanner(System.in);
          String curSub=sc.nextLine(); 
          System.out.println("enter marks");
          int curMarks=sc.nextInt();
          return new Score(curSub,curMarks); 
     }

}
 
