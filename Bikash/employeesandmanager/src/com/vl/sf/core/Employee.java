package com.vl.sf.core;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
	@Override
	public String toString() {
		return id+" "+name+" "+salary+" "+dob;
	}

	private List<Employee> directReportees = new ArrayList<Employee>();
	protected int id;
	protected String name;
	protected double salary;
	protected Department department;
	protected Employee manager;
	protected Date dob;

	protected Employee(int id, String name, double salary, Department department,Date dob) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.dob=dob;
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

	public Employee getManager() {
		return manager;
	}
	
	
	protected void setReporteeAndManagerDetails(Employee employee) {
		directReportees.add(employee);
		if (employee.manager == null
				|| employee.manager.getName() == employee.department
						.getDeptManager().getName())
			employee.manager = this;
	}
	
	public int getNoOfDirectReportees() {
		return directReportees.size();
	}

	public List<Employee> getDirectReportees() {
		return directReportees;
	}
}
