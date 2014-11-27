package com.vl.sf.core;


import java.util.Scanner;

public class Course {
	private Student[] students = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("No. of Students:");
		int noOfStudents = scanner.nextInt();
		Course course = new Course();
		course.students = new Student[noOfStudents];
		for (int i = 0; i < noOfStudents; i++) {
			course.students[i] = Student.readMe(scanner);
		}
		int maxMarkStudent = course.students[0].getTotalMarks();
		int maxMarkStudentNameIndex = 0;
		for (int i = 1; i < noOfStudents; i++) {
			int nextMark = course.students[i].getTotalMarks();
			if (maxMarkStudent < nextMark) {
				maxMarkStudent = nextMark;
				maxMarkStudentNameIndex = i;
			}
		}
		MaxMarkStudentDetails maxDetails = course.students[maxMarkStudentNameIndex]
				.getMaxMarkStudentDetails();
		System.out.println("Highest Marks " + maxDetails.getMark()
				+ " By " + maxDetails.getName());
		MaxMarkStudentDetails[] maxMarkStudentDetails=new MaxMarkStudentDetails[noOfStudents];
		for (int i = 0; i < noOfStudents; i++) {
			maxMarkStudentDetails[i]=course.students[i].getMaxMarkSubject();
			System.out.println(maxMarkStudentDetails[i].getName()+" Highest "+maxMarkStudentDetails[i].getMark()+" mark in subject "+maxMarkStudentDetails[i].getSubject());
		}

	}

}
