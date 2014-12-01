package com.vl.sf.core;

import java.util.Scanner;

public class Course {
	private Student[] students = null;
	private MaxMarkStudentDetails maxDetails=null;
	private MaxMarkStudentDetails[] maxMarkSubjectDetails=null;
	
	public static Course getCourseAndSubjectDetails(Scanner scanner){
		
		System.out.print("No. of Students:");
		int noOfStudents = scanner.nextInt();
		Course course = new Course();
		course.students = new Student[noOfStudents];
		System.out.print("No. Of subjects: ");
		int noOfSubjects=scanner.nextInt();
		for (int i = 0; i < noOfStudents; i++) {
			course.students[i] = Student.readMe(scanner, noOfSubjects);
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
		course.maxDetails = course.students[maxMarkStudentNameIndex]
				.getMaxMarkStudentDetails();
		course.maxMarkSubjectDetails=new MaxMarkStudentDetails[noOfStudents];
		return course;
	}
	
	
	public MaxMarkStudentDetails getMaxDetails() {
		return maxDetails;
	}


	public MaxMarkStudentDetails[] getMaxMarkSubjectDetails() {
		return maxMarkSubjectDetails;
	}


	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Course course=getCourseAndSubjectDetails(scanner);
		MaxMarkStudentDetails maxDetails=course.getMaxDetails();
		System.out.println("Highest Marks " + maxDetails.getMark()
				+ " By " + maxDetails.getName());
		MaxMarkStudentDetails[] maxMarkSubjectDetails=course.getMaxMarkSubjectDetails(); 
		int noOfStudents=maxMarkSubjectDetails.length;
		for (int i = 0; i < noOfStudents; i++) {
			maxMarkSubjectDetails[i]=course.students[i].getMaxMarkSubject();
			System.out.println(maxMarkSubjectDetails[i].getName()+" Highest "+maxMarkSubjectDetails[i].getMark()+" mark in subject "+maxMarkSubjectDetails[i].getSubject());
		}
		
	}

}
