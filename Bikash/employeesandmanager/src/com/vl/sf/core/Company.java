package com.vl.sf.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
	private Map<String, Department> departments = new HashMap<String, Department>();
	private List<Employee> allEmployees = new ArrayList<Employee>();
	public static String name;
	public static String url;
	public static Employee CEO;

	public Map<String, Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Map<String, Department> departments) {
		this.departments = departments;
	}

	public void displayAllEmployeeDetails(List<Employee> allEmployees) {
		if (allEmployees != null & allEmployees.size() > 0) {
			Employee employee;
			for (int index = 0; index < allEmployees.size(); index++) {
				employee = allEmployees.get(index);
				displayManager(employee);
				if (employee.getDirectReportees().size() > 0) {
					System.out.println("\n The no. of Direct Reportees of "
							+ employee.getName() + " is : "
							+ getNoOfDirectReportees(employee));
					System.out
							.println("\n Direct reportees Structure is given below: ");
					System.out.println("\t" + employee.getName());
					System.out.print("\t=======");
					displayDirectReporteesNames(employee);
				}
			}
			for (int index = 1; index <=allEmployees.get(0).getNoOfDirectReportees(); index++) {
				employee = allEmployees.get(index);
				printDepth(employee);
			}
		}
	}

	public static void displayManager(Employee employee) {
		Employee manager = employee.getManager();
		if (manager == null) {
			System.out.println("\n " + employee.getName() + " is the CEO of "
					+ name);
		} else
			System.out.println("\n " + employee.getName() + "'s Manager is : "
					+ manager.getName());
	}

	public static void displayDirectReporteesNames(Employee manager) {
		List<Employee> directReportees = manager.getDirectReportees();
		if (directReportees != null && directReportees.size() > 0) {
			for (int index = 0; index < manager.getNoOfDirectReportees(); index++) {
				System.out.println("\n\t-> "
						+ directReportees.get(index).getName());
			}
		}
	}

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}

	private Employee getManagerById(int empId) {
		for (int index = 0; index < allEmployees.size(); index++) {
			Employee manager = allEmployees.get(index);
			if (empId == manager.id) {
				return manager;
			}
		}
		return null;
	}

	public static int getNoOfDirectReportees(Employee manager) {
		return manager.getNoOfDirectReportees();
	}

	public static Company getCompany(BufferedReader companyDetails,
			BufferedReader departmentDetails, BufferedReader employeeDetails)
			throws IOException {
		Company company = new Company();
		String record = null;
		int i;
		String ceoName = null;
		int ceoId = 0;
		String ceoDob = null;
		String[] date;
		int day=0;
		int month=0;
		int year = 0;
		while ((record = companyDetails.readLine()) != null) {
			String[] allData = record.split(",");
			i = 0;
			if (allData != null) {
				name = allData[i++];
				url = allData[i++];
				ceoName = allData[i++];
				ceoId = Integer.parseInt(allData[i++]);
				ceoDob = allData[i++];
				date=company.dateSplitter(ceoDob);
				day=Integer.parseInt(date[0]);
				month=Integer.parseInt(date[1]);
				year=Integer.parseInt(date[2]);
			}
		}
		while ((record = departmentDetails.readLine()) != null) {
			String[] allData = record.split(",");
			i = 0;
			for (int j = 0; j < allData.length; j++) {
				company.departments.put(allData[i],
						new Department(allData[i++]));
			}
		}
		CEO = new Employee(ceoId, ceoName, 00, company.departments.get(0),
				new Date(year, month-1, day));
		System.out.println(CEO.getDob());
		company.allEmployees.add(CEO);
		while ((record = employeeDetails.readLine()) != null) {
			String[] allData = record.split(",");
			i = 0;
			if (allData != null) {
				// i=0;
				int empId = Integer.parseInt(allData[i++]);
				String empName = allData[i++];
				double empSalary = Double.parseDouble(allData[i++]);
				int mngId = Integer.parseInt(allData[i++]);
				String dept = allData[i++];
				String design = allData[i++];
				String dob = allData[i++];
				date=company.dateSplitter(dob);
				day=Integer.parseInt(date[0]);
				month=Integer.parseInt(date[1]);
				year=Integer.parseInt(date[2]);
				Employee manager = company.getManagerById(mngId);
				Employee employee = new Employee(empId, empName, empSalary,
						company.departments.get(dept),new Date(year, month-1, day));
				company.allEmployees.add(employee);
				if (manager != null) {
					manager.setReporteeAndManagerDetails(employee);
				}
			}
		}
		return company;
	}
	
	public String[] dateSplitter(String date){
		String[] all=date.split("/");
		return all;
	}

	public static void printDepth(Employee manager) {
		System.out.println("\n The Depth of the Manager " + manager.getName()
				+ " is : " + manager.getDepth(manager));
	}
	
	public static Employee getMaxAgeEmployee(List<Employee> allEmployee){
		Employee maxAgeEmployee=allEmployee.get(0);
		for (int index = 1; index <allEmployee.size(); index++) {
			Employee nextEmployee=allEmployee.get(index);
			if(maxAgeEmployee.getDob().compareTo(nextEmployee.getDob())>0){
				maxAgeEmployee=nextEmployee;
			}
		}
		return maxAgeEmployee;
	}

	public static void main(String[] args) {
		BufferedReader companyDetails = null;
		BufferedReader employeeDetails = null;
		BufferedReader departmentDetails = null;
		Company company = null;
		try {
			companyDetails = new BufferedReader(new FileReader(
					args[0]));
			departmentDetails = new BufferedReader(new FileReader(
					args[1]));
			employeeDetails = new BufferedReader(new FileReader(
					args[2]));

			companyDetails.readLine();
			departmentDetails.readLine();
			employeeDetails.readLine();
			company = Company.getCompany(companyDetails, departmentDetails,
					employeeDetails);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		if (company != null) {
			List<Employee> allEmployees = company.getAllEmployees();
			company.displayAllEmployeeDetails(allEmployees);
			Employee maxAgeEmployee=company.getMaxAgeEmployee(allEmployees);
			System.out.println(maxAgeEmployee.getName()+" is the max Age person of the company "+Company.name);
		}

	}
}
