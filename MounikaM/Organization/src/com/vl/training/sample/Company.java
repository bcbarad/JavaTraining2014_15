package com.vl.training.sample;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

class Company {
    private String cmpname;
    private String cmpurl;
    public Employee ceo;
    public List<Employee> allEmployees = new ArrayList<Employee>();
    public Map<String, Department> deptMap = new HashMap<String, Department>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");

    public void readCompanyDetails(Scanner sc, Scanner s, Scanner scn) {
                                                                       // To read company and employee details.
        String name = null;
        int id = 0;
        double sal;
        Date dob = null;
        String deptName = null;
        String nextdeptName = null;

        cmpname = sc.next();                   // Reading Company name and it's CEO and Company Url
        cmpurl = sc.next();
        name = sc.next();
        id = sc.nextInt();
        sal = sc.nextDouble();
        try {
            dob = sdf.parse(sc.next());
        } catch(Exception e ) {
            System.err.println(e);
        }
        while (s.hasNext()) {                 // Reading Departments which are present in given company
            deptName = s.next();
            nextdeptName = s.next();
            deptMap.put(deptName, new Department(nextdeptName));
        }
        ceo = new Employee(name, id, sal, deptMap.get(deptName), dob);
        System.out.println("CEO : " + ceo.getEname());
        System.out.println("CEO dob:" + ceo.getDob());
        allEmployees.add(ceo);

        while (scn.hasNext()) {             // To read every department employees
            name = scn.next();
            id = scn.nextInt();
            sal = scn.nextDouble();
            deptName = scn.next();
            try {
                dob = sdf.parse(scn.next());
            } catch(Exception e ) {
                System.err.println(e);
            }

            Employee e = new Employee(name, id, sal, deptMap.get(deptName), dob);
            int mid = scn.nextInt();

            Employee manager = getManager(mid);
            allEmployees.add(e);
            manager = manager;
            if (manager != null) {
                manager.alldirectrepotiees.add(e);   // Adding directRepotiees to their respective manager
            }


        }
    }
    public String getCmpname() {
        return cmpname;
    }
    public String getCmpurl() {
        return cmpurl;
    }

    public Employee getManager(int managerId) {               // To get find manager for given emplyee
        for (int i = 0; i < allEmployees.size(); i++) {
            Employee e = allEmployees.get(i);
            if (managerId == e.getEmpid()) {
                return e;
            }
        }
        System.out.println("Could not find manager for the given id: " + managerId);
        return null;
    }

   /* public static void main(String[] args) {
        if (args.length >= 2) {
            try {
                Employee emp;
                Employee e;
                Scanner sc = new Scanner(new File(args[0]));
                Scanner sc1 = new Scanner(new File(args[1]));
                Scanner sc2 = new Scanner(new File(args[2]));
                Company c = new Company();
                c.readCompanyDetails(sc, sc1,  sc2);
                c.printAllDirectRepotiees(c.allEmployees);
                emp = c.getMaxAge(c.allEmployees);
                System.out.println(emp.getEname() + " has maximum age");
                e = c.getLongestHod(c.allEmployees);
                System.out.println(e.getEname() + " has longest chain");


            } catch (FileNotFoundException nfe) {
                System.err.println(nfe);
            }

        } else {
            System.out.println("\n please enter  2 file names as argument");
        }
    }*/

    public void printAllDirectRepotiees(List<Employee> allEmployees) {         // To print all Employees in company and the number of reportiees for every employee
        for (Employee e : allEmployees) {
            if (e.alldirectrepotiees != null) {
                System.out.println(e.getEname() + " has " + e.alldirectrepotiees.size()+ " direct repotiees");
            } else {
                System.out.println(e.getEname() + "don't have direct repotiees");
            }
        }
    }

    public int getNumberofDirectieesofEMP(Employee e) { // to get Longest chain for given employee/Manager
        int depth = 0;
        int storingDepth = 0;
        int finalDepth = 0;
        if (e.alldirectrepotiees != null) {
            depth++;
            for (Employee emp  : e.alldirectrepotiees) {
                storingDepth = getNumberofDirectieesofEMP(emp);
                if (finalDepth < storingDepth) {
                    finalDepth = storingDepth;
                }
            }
        }
        return finalDepth + 1;
    }
    public Employee getLongestchainHod(List<Employee> allEmployees) { // To get To get highest chain among the all others
        Employee ceo = allEmployees.get(0);
        Employee emp = null;
        int empsUnderHod = 0;
        for (Employee e : ceo.alldirectrepotiees) {
            int length = getNumberofDirectieesofEMP(e);
            if (empsUnderHod < length) {
                empsUnderHod = length;
                emp = e;
            }
        }
        return emp;
    }
    public Employee getMaxAge(List<Employee> allEmployees) {

        Employee emp = allEmployees.get(0);
        for (int j = 1; j < allEmployees.size(); j++) {
            Employee nextEmp = allEmployees.get(j);
            if ((emp.getDob().compareTo(allEmployees.get(j).getDob())) > 0) {
                emp = nextEmp;
            }
        }
        return emp;
    }
}
