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
	private Map<String,Department> departments =new HashMap<String, Department>();
	private List<Employee> allEmployees = new ArrayList<Employee>();
	public static String name;
	public static String url;
	public static Employee CEO;

	public Map<String,Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Map<String,Department> departments) {
		this.departments = departments;
	}

	public void displayAllEmployeeDetails(List<Employee> allEmployees) {
		if (allEmployees != null & allEmployees.size() > 0) {
			Employee employee;
			for (int index = 0; index < allEmployees.size(); index++) {
				employee = allEmployees.get(index);
				displayManager(employee);
				if (employee.getDirectReportees().size() > 1) {
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
		if (directReportees != null & directReportees.size() > 0) {
			for (int index = 0; index < manager.getNoOfDirectReportees(); index++) {
				System.out.println("\n\t-> "
						+ directReportees.get(index).getName());
			}
		}
	}

	public List<Employee> getAllEmployees() {
		return allEmployees;
	}
	public Employee getEmployee(int empId){
		
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
		while ((record = companyDetails.readLine()) != null) {
			String[] allData = record.split(",");
			i = 0;
			if (allData != null) {
				name = allData[i++];
				url = allData[i++];
				ceoName = allData[i++];
				ceoId = Integer.parseInt(allData[i++]);
				ceoDob = allData[i++];
			}
		}
		while ((record = departmentDetails.readLine()) != null) {
			String[] allData = record.split(",");
			i = 0;
			for (int j = 0; j < allData.length; j++) {
				company.departments.put(allData[i],new Department(allData[i++]));
			}
		}
		System.out.println(company.departments);
		CEO = new Employee(ceoId, ceoName, 00,
				company.departments.get(0), new Date(ceoDob));
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
				company.allEmployees.add(new Employee(empId,empName,empSalary,company.departments.get(dept),new Date(dob)));
			}
		}
		System.out.println(company.allEmployees);
		return company;
	}

	public static void main(String[] args) {
		BufferedReader companyDetails = null;
		BufferedReader employeeDetails = null;
		BufferedReader departmentDetails = null;
		Company company = null;
		try {
			companyDetails = new BufferedReader(new FileReader(
					"companydetails.txt"));
			departmentDetails = new BufferedReader(new FileReader(
					"departmentdetails.txt"));
			employeeDetails = new BufferedReader(new FileReader(
					"employeedetails.txt"));

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
		}

	}
}
