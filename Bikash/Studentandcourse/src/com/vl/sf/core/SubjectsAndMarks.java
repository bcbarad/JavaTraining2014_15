package com.vl.sf.core;

import java.util.Scanner;

public class SubjectsAndMarks {
	private String subject = null;
	private int mark = 0;

	public static SubjectsAndMarks readMe(Scanner scanner) {
		SubjectsAndMarks subjectsAndMarks = new SubjectsAndMarks();
		System.out.print("Subject Name:");
		subjectsAndMarks.subject = scanner.next();
		System.out.print("Mark in " + subjectsAndMarks.subject + " :");
		subjectsAndMarks.mark = scanner.nextInt();
		return subjectsAndMarks;
	}

	public String getSubject() {
		return subject;
	}

	public int getMark() {
		return mark;
	}
}







class Marks {
    String subname="";
    int submarks=0;
    public Marks readMe(final Scanner sc) {
         Marks m=new Marks();
         System.out.println("enter the subject name:");
         subname=sc.next();
         System.out.println("enter the"+subname+"marks");
         submarks=sc.nextInt();
         return m;  
    }
}
