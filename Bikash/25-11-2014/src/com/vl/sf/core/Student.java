package com.vl.sf.core;

import java.util.Scanner;

public class Student {
	private String name = null;
	private SubjectsAndMarks[] sMarks = null;
	private int totalMarks = 0;
	
	public static Student readMe(Scanner scanner) {

		Student student = new Student();
		System.out.print("Name of the student:");
		student.name = scanner.next();
		System.out.print("No. of subjects:");
		int noOfSubjects = scanner.nextInt();
		student.sMarks = new SubjectsAndMarks[noOfSubjects];
		for (int i = 0; i < noOfSubjects; i++) {
			student.sMarks[i] = SubjectsAndMarks.readMe(scanner);
			student.totalMarks += student.sMarks[i].getMark();
		}
		// System.out.println(student.totalMarks);
		return student;
	}

	public MaxMarkStudentDetails getMaxMarkStudentDetails() {
		MaxMarkStudentDetails maxMarkStudentDetails = new MaxMarkStudentDetails();
		maxMarkStudentDetails.setName(getName());
		maxMarkStudentDetails.setMark(getTotalMarks());
		return maxMarkStudentDetails;
	}
	public MaxMarkStudentDetails getMaxMarkSubject(){
		int noOfSubject=sMarks.length;
		int maxMarkSubject = sMarks[0].getMark();
		int maxMarkSubjectNameIndex = 0;
		for (int i = 1; i < noOfSubject; i++) {
			int nextMark = sMarks[i].getMark();
			if (maxMarkSubject < nextMark) {
				maxMarkSubject = nextMark;
				maxMarkSubjectNameIndex = i;
			}
		}
		MaxMarkStudentDetails maxMarkStudentDetails = new MaxMarkStudentDetails();
		maxMarkStudentDetails.setName(getName());
		maxMarkStudentDetails.setMark(sMarks[maxMarkSubjectNameIndex].getMark());
		maxMarkStudentDetails.setSubject(sMarks[maxMarkSubjectNameIndex].getSubject());
		return maxMarkStudentDetails;
		
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public String getName() {
		return name;
	}

}
