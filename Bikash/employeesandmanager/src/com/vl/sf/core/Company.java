package com.vl.sf.core;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company {
	private List<Employee> allEmployees = new ArrayList<Employee>();
	public static String name;
	public static String url;
	public static Employee CEO;

	public void getDetails(List<Employee> allEmployees) {
		if (allEmployees != null & allEmployees.size() > 0) {
			Employee employee;
			for (int index = 0; index < allEmployees.size(); index++) {
				employee = allEmployees.get(index);
				displayManager(employee);
				if (employee.getDirectReportees().size()>1) {
					getNoOfDirectReportees(allEmployees.get(index));
					System.out
							.println("\n Direct reportees Structure is given below: ");
					System.out.println("\t"
							+ (allEmployees.get(index)).getName());
					System.out.print("\t=======");
					displayDirectReporteesNames(allEmployees
							.get(index));
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

	public void readEmployeesData(String cEO){
		Department all = new Department("All");
		Department hr = new Department("HR");
		Department development = new Department("Development");

		Employee CEO = new Employee(100, cEO, 000, all,new Date("1/9/1975"));
		
		Employee hrManager = new Employee(101, "Bikash", 1000000, hr,new Date("12/3/1985"));
		hr.setDeptManager(hrManager);
		Employee developmentManager = new Employee(102, "Tarun", 100500, development,new Date("6/7/1982"));
		development.setDeptManager(developmentManager);

		Employee lova = new Employee(103, "Lova", 10056, hr,new Date("2/4/1986"));
		
		
		
		Employee lavanya = new Employee(104, "Lavanya", 10598, hr,new Date("8/5/1985"));
		Employee dheeraja=new Employee(125,"Dheraja",15879,hr,new Date("9/7/1990"));
		Employee abhi = new Employee(105, "Abhi", 25879, development,new Date("6/25/1991"));
		Employee ashok = new Employee(106, "Ashok", 23658, development,new Date("3/5/1993"));
		Employee alok = new Employee(107, "Alok", 10254, development,new Date("3/28/1992"));

		CEO.setReporteeAndManagerDetails(hrManager);
		CEO.setReporteeAndManagerDetails(developmentManager);
		hrManager.setReporteeAndManagerDetails(lova);
		hrManager.setReporteeAndManagerDetails(lavanya);
		hrManager.setReporteeAndManagerDetails(dheeraja);
		developmentManager.setReporteeAndManagerDetails(abhi);
		developmentManager.setReporteeAndManagerDetails(ashok);
		developmentManager.setReporteeAndManagerDetails(alok);

		Employee keerthi = new Employee(108, "Keerthi", 8956, hr,new Date("7/19/1990"));
		Employee gaurav = new Employee(109, "Gaurav", 9879, hr,new Date("10/29/1989"));
		Employee deepika = new Employee(110, "Deepika", 9989, hr,new Date("6/4/1997"));
		Employee pawan = new Employee(111, "Pawan", 9999, development,new Date("2/14/1993"));

		lova.setReporteeAndManagerDetails(keerthi);
		lova.setReporteeAndManagerDetails(gaurav);
		lova.setReporteeAndManagerDetails(deepika);
		abhi.setReporteeAndManagerDetails(pawan);

		Employee rajeev = new Employee(112, "Rajeev", 8572, hr,new Date("13/4/1987"));
		Employee ram = new Employee(113, "Ram", 8762, hr,new Date("19/4/1986"));
		Employee sasanka = new Employee(114, "Sasanka", 6589, hr,new Date("04/4/1989"));
		Employee sambit = new Employee(115, "Sambit", 2356, hr,new Date("09/4/1980"));
		Employee yasodhara = new Employee(116, "Yasodhara", 7894, development,new Date("20/4/1987"));
		Employee binita = new Employee(117, "Binita", 5478, development,new Date("26/4/1983"));
		Employee anil = new Employee(118, "Anil", 8888, development,new Date("22/4/1981"));

		keerthi.setReporteeAndManagerDetails(rajeev);
		gaurav.setReporteeAndManagerDetails(ram);
		gaurav.setReporteeAndManagerDetails(sasanka);
		gaurav.setReporteeAndManagerDetails(sambit);
		pawan.setReporteeAndManagerDetails(yasodhara);
		pawan.setReporteeAndManagerDetails(binita);
		pawan.setReporteeAndManagerDetails(anil);

		allEmployees.add(CEO);
		allEmployees.add(hrManager);
		allEmployees.add(developmentManager);
		allEmployees.add(lova);
		allEmployees.add(lavanya);
		allEmployees.add(abhi);
		allEmployees.add(ashok);
		allEmployees.add(alok);
		allEmployees.add(keerthi);
		allEmployees.add(gaurav);
		allEmployees.add(deepika);
		allEmployees.add(pawan);
		allEmployees.add(rajeev);
		allEmployees.add(ram);
		allEmployees.add(sasanka);
		allEmployees.add(sambit);
		allEmployees.add(yasodhara);
		allEmployees.add(binita);
		allEmployees.add(anil);
	}
	
	public static void getNoOfDirectReportees(Employee manager) {
		System.out.println("\n The no. of Direct Reportees of "
				+ manager.getName() + " is : " + manager.getNoOfDirectReportees());
	}
	
	public static Company createCompany(String cName, String cUrl, String cEO) {
		Company company = new Company();
		Company.name = cName;
		Company.url = cUrl;
		company.readEmployeesData(cEO);
		return company;
	}

	public static void main(String[] args) {
		List<Employee> allEmployees = new ArrayList<Employee>();
		Company company = Company.createCompany("ValueLabs",
				"www.valuelabs.com", "Arjun");
		allEmployees = company.getAllEmployees();
		company.getDetails(allEmployees);
	}

}
