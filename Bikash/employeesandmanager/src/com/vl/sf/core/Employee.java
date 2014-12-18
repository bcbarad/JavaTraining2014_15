package com.vl.sf.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
	@Override
	public String toString() {
		return id + " " + name + " " + salary + " " + manager.id + "\n";
	}

	private List<Employee> directReportees = new ArrayList<Employee>();
	protected int id;
	private String name;
	private double salary;
	private Department department;
	private Employee manager;
	private Date dob;
	private int depth = 0;
	private int maxDepth = 0;

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

	public List<Employee> getDirectReportees(Employee manager) {
		return directReportees;
	}

	public int getDepth(Employee manager) {
		for (int index = 0; index < manager.getNoOfDirectReportees(); index++) {
			directReportees = manager.getDirectReportees(manager);
			if (maxDepth < depth) {
				maxDepth = depth;
				depth = 0;
			}
			if (directReportees.get(index).getNoOfDirectReportees() > 0) {
				getDepth(directReportees.get(index));
				depth++;
			} else {
				break;
			}
		}
		maxDepth++;
		return maxDepth;
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
