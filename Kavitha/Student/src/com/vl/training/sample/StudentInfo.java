import java.io.*;
import java.util.Scanner;
class StudentInfo {
    public static void main(final String []args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(args[ 0 ]));
	Course s = Course.readMe(scn);
	Course.display(s);
	Course.getTotal(s);
	Course.getTotMax(s);
	Course.getSubjectMax(scn,s);
	}
}
class Course {
    static int numStudents; 
    Student []allStudents;
    public static Course readMe(final Scanner scn) {
        Course c = new Course();   
	// System.out.println("Enter no. of students:");
	numStudents = scn.nextInt();
	c.allStudents = new Student[numStudents];
	for (int i = 0; i < numStudents; i++) {
	    c.allStudents[i] = Student.readMe(scn);
	}
	return c; 
    }
    public static void display(final Course c) {
        System.out.println(" StName \t SubName \t Marks");
	for (int j = 0; j < c.numStudents; j++) {
	    System.out.println(c.allStudents[ j ].studentName);
	    for (int k = 0; k < Student.numSubjs; k++) {
	        System.out.println("\t\t" + c.allStudents[ j ].allScores[ k ].subName + "\t\t" + c.allStudents[ j ].allScores[ k ].marks);
	    }
	}
}   
    public static void getTotal(final Course c) {
	int []totalMarks = new int[Student.numSubjs];
	System.out.println(" StName \t  Marks");
	for (int l = 0; l < c.numStudents; l++) {
	    for (int m = 0; m < Student.numSubjs; m++) {
		totalMarks[ l ] = totalMarks[ l ] + c.allStudents[ l ].allScores[ m ].marks;
	    }
	    System.out.println(c.allStudents[ l ].studentName + "  \t\t " + totalMarks[ l ]);
	}
    }
    public static void getTotMax(final Course c) {
        int marks = 0;
	String name = "";
	int []totalMarks = new int[ Student.numSubjs ];
	System.out.println(" StName \t  Marks");
	for (int l = 0; l < c.numStudents; l++) {
	    for (int m = 0; m < Student.numSubjs; m++) {
	        totalMarks[ l ] = totalMarks[ l ] + c.allStudents[ l ].allScores[ m ].marks;
	    }
	    if (marks < totalMarks[ l ]) {
		marks = totalMarks[ l ];
		    name = c.allStudents[ l ].studentName;       
	    }
	}  
	System.out.println("the highest marks: " + marks + "scored by" + name);
    }
    public static void getSubjectMax(final Scanner scn,final Course c) {
        int maxMarks = 0;
        String subName = "";
        System.out.println("enter the name of subject to know the highest mark for it:");
        subName = scn.nextLine();
        for (int l = 0; l < c.numStudents; l++) {
            for (int m = 0;m < Student.numSubjs; m++) {
	        if (subName.equals(c.allStudents[ l ].allScores[ m ].subName)) {
		     if (maxMarks < c.allStudents[ l ].allScores[ m ].marks) {
		          maxMarks = c.allStudents[ l ].allScores[ m ].marks;
		     } 
	        }
	    }
        }
       System.out.println("the highest marks are : " + maxMarks);
   }
}
class Student {
    String studentName;
    Score[] allScores;
    //static Scanner scn=new Scanner(System.in);
    static int numSubjs;
    public static Student readMe(final Scanner scn) {
        Student s = new Student();
	//System.out.println("Enter No of subjects:"); 
        numSubjs = scn.nextInt();
        // System.out.println("Enter student details");
	String details = scn.nextLine();
	// System.out.println("Enter student name:");
	s.studentName = scn.nextLine();
	s.allScores = new Score[ s.numSubjs ];
	for (int i = 0; i < s.numSubjs; i++) {
	    s.allScores[ i ] = Score.readMe();
	}
        return s;
    }
}
class Score {
    public String subName;
    public int marks;
    public static Score readMe() {
        Scanner scn = new Scanner(System.in);
	//   System.out.println("Enter sub name:");
	String curSub = scn.nextLine();
	//  System.out.println("Enter marks");
	int curMarks = scn.nextInt();
	Score sc = new Score();
	sc.subName = curSub;
	sc.marks = curMarks;
	return sc;
    }
}
