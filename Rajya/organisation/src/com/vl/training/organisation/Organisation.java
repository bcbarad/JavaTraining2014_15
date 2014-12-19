package com.vl.training.organisation;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public final class Organisation {

    private Organisation() {
    }

    public static void main(final String[] arr) throws IOException {
        if (arr.length != 1) {
            System.out.println("Input parameter should be exactly one");
            return;
        } else {
            Scanner sc = new Scanner(new File(arr[0]));
            // Creating dynamic company data structure
            createStructure(sc);
        }
    }

    static void createStructure(final Scanner sc) {
        Company c = Company.readCompany(sc);
        System.out.println("CEO :" + c.ceo.getId());
        c.printHierarchy(c.ceo);
        Employee maxAgedEmp = c.getMaxAgeEmployee(c.ceo);
        System.out.println("Max Age Employee : " + maxAgedEmp.getId());
        System.out.println("Chain Length :" + c.count + " Employee ID : " + c.longestReportee.getId());
    }
}

class Company {

    Employee ceo;
    Employee longestReportee = null;
    static Employee maxAge;
    private String name;
    private String uri;
    static int count = 0;

    void setName(final String ename) {
        this.name = ename;
    }

    String getName() {
        return name;
    }

    void setUri(final String euri) {
        this.uri = euri;
    }

    String getUri() {
        return uri;
    }

    // Prints all the reportees starting from the ceo
    void printHierarchy(final Employee ceo) {
        count = 0;
        for (Employee e : ceo.directReportees) {
            System.out.println("Employee : " + e.getId() + "  Name : " + e.getName() + "  Manager ID : " + e.manager.getId());
            if (!e.directReportees.isEmpty()) {
                printHierarchy(e);
                count++;
                longestReportee = e;
            }
        }
    }

    // Gives the employee object who is having maximum age
    Employee getMaxAgeEmployee(final Employee current) {
        for (Employee e: current.directReportees) {
            if (e.getDOB().compareTo(maxAge.getDOB()) < 0) {
                maxAge = e;
            }
            if (!e.directReportees.isEmpty()) {
                Employee foundEmp = getMaxAgeEmployee(e);
                if (foundEmp == null) {
                    return null;
                }
            }
        }
        return maxAge;
    }

    // Reads company details
    static Company readCompany(final Scanner sc) {
        Company com = new Company();
        com.name = sc.next();
        com.uri = sc.next();
        com.ceo = Employee.readEmployee(sc);
        maxAge = com.ceo;
        while (sc.hasNext()) {
            Employee emp = Employee.readEmployee(sc);
            String mgrId = sc.next();
            Employee mgr = com.getEmployee(mgrId, com.ceo);
            //Linking the Employee Object with his manager Employee Object
            mgr.directReportees.add(emp);
            //Setting the managerfield of Employee object
            emp.manager = mgr;
        }
        return com;
    }

    // Gives the employee object of the direct reportee to the manager
    Employee getEmployee(final String mgrid, final Employee current) {
        // Gives employee object whose managerid matches with the employeeid
        if (current.getId().equals(mgrid)) {
            return current;
        } else {
            if (current.directReportees == null) {
                return null;
            } else {
                Iterator<Employee> itr = current.directReportees.iterator();
                while (itr.hasNext()) {
                    Employee e = itr.next();
                    Employee foundEmp = getEmployee(mgrid, e);
                    if (foundEmp != null) {
                        return foundEmp;
                    }
                }
            }
        }
        return null;
    }
}

class Employee {

    private String name;
    private String id;
    private int salary;
    private Date dob;
    Employee manager;
    ArrayList<Employee> directReportees = new ArrayList<Employee>();

    // Reads employee details
    static Employee readEmployee(final Scanner sc) {
        Employee emp = new Employee();
        emp.setId(sc.next());
        emp.setName(sc.next());
        emp.setSalary(sc.nextInt());
        emp.setDOB(sc.next());
        return emp;
    }

    void setName(final String ename) {
        this.name = ename;
    }

    String getName() {
        return name;
    }

    void setId(final String eid) {
        this.id = eid;
    }

    String getId() {
        return id;
    }

    void setSalary(final int esalary) {
        this.salary = esalary;
    }

    int getSalary() {
        return salary;
    }

    void setDOB(final String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dob = (Date) formatter.parse(dateInString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Date getDOB() {
        return dob;
    }
}
