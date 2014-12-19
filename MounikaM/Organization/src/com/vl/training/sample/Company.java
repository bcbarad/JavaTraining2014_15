package com.vl.training.sample;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Company {
    private String cmpname;
    private String cmpurl;
    public Employee ceo;
    public List<Employee> allEmployees = new ArrayList<Employee>();
   // public Department[] allDepartments;

    public Company companyDetails(Scanner sc, Scanner scn) {
                                                                       // To read company and employee details.
        String name = null;
        int id = 0;
        double sal;
        int i = 0;
        Company cmp = new Company();
        Employee emp = new Employee();
        // Department d = new Department();
        cmp.cmpname = sc.next();
        cmp.cmpurl = sc.next();
        name = sc.next();
        id = sc.nextInt();
        sal = sc.nextDouble();
        cmp.ceo = new Employee(name, id, sal);
        cmp.allEmployees.add(ceo);

        while (scn.hasNext()) {
            name = scn.next();
            id = scn.nextInt();
            sal = scn.nextDouble();
            Employee e = new Employee(name, id, sal);
            int mid = scn.nextInt();

            Employee manager = cmp.getManager(mid);
            cmp.allEmployees.add(e);
            emp.manager = manager;
            if (manager != null ) {
                manager.alldirectrepotiees.add(e);   // Adding directRepotiees to their respective manager
            }


        }
        return cmp;
    }

    public String getCmpname() {
        return cmpname;
    }
    public String getCmpurl() {
        return cmpurl;
    }

    public Employee getManager(int managerId) {               // To get find manager for given emplyee
        for (int i = 0; i < allEmployees.size(); i++ ) {
            Employee e = allEmployees.get(i);
            if (managerId == e.getEmpid()) {
                return e;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length == 2 ) {
            try {
                Scanner sc = new Scanner(new File(args[0]));
            //Scanner sc1 = new Scanner(new File(args[1]));
                Scanner sc2 = new Scanner(new File(args[1]));
                Company c = new Company();
                Company cmpDetails = c.companyDetails(sc, sc2);
            } catch(FileNotFoundException nfe) {
                System.err.println(nfe);
            }
            //  c.printcompanyDetails(cmpDetails);

        } else {
            System.out.println("\n please enter  2 file names as argument");
        }
    }
}
