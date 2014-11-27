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
