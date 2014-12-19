package com.vl.sf.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
	@Override
	public String toString() {
		return id + " " + name + " " + salary + " " + dob + "\n";
	}

	private List<Employee> directReportees = new ArrayList<Employee>();
	public int getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	public void setDirectReportees(List<Employee> directReportees) {
		this.directReportees = directReportees;
	}

	protected int id;
	private String name;
	private double salary;
	private Department department;
	private Employee manager;
	private Date dob;
	//private int depth = 0;
	protected int maxDepth = 0;

	public Employee(int id, String name, double salary, Department department,
			Date dob) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.dob = dob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}

	public Employee getManager() {
		return manager;
	}

	public static int getDepth(Employee manager) {
		for (int index = 0; index < manager.getNoOfDirectReportees(); index++) {
			List<Employee> directReportees = manager.getDirectReportees();
			if (directReportees.size() == 0) {
				manager.maxDepth = 0;
			} else {
				getDepth(directReportees.get(index));
				manager.maxDepth=getDepth(directReportees.get(0));
				for (int i = 1; i <directReportees.size(); i++) {
					int temp=getDepth(directReportees.get(i));
					if(manager.maxDepth<temp){
						manager.maxDepth=temp;
					}
				}
				manager.maxDepth++;
			}
		}
		return manager.maxDepth;
	}

	protected void setReporteeAndManagerDetails(Employee employee) {
		directReportees.add(employee);
		if (employee.manager == null)
			employee.manager = this;
	}

	public int getNoOfDirectReportees() {
		return directReportees.size();
	}

	public List<Employee> getDirectReportees() {
		return directReportees;
	}

}
