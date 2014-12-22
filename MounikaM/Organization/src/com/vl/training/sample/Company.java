package com.vl.training.sample;
import java.lang.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

public class Company {
    private String cmpname;
    private String cmpurl;
    public Employee ceo;
    public List<Employee> allEmployees = new ArrayList<Employee>();
    public Map<String, Department> deptMap = new HashMap<String, Department>();

    public void companyDetails(Scanner sc, Scanner s, Scanner scn) {
                                                                       // To read company and employee details.
        String name = null;
        int id = 0;
        double sal;
        int i = 0;
        String[] date;
        String dob = null;
        String deptName = null;
        String nextdeptName = null;
        int day = 0;
        int month = 0;
        int year = 0;
        Employee emp = new Employee();
        cmpname = sc.next();
        cmpurl = sc.next();
        name = sc.next();
        id = sc.nextInt();
        sal = sc.nextDouble();
        dob = sc.next();
        date = dateSplitter(dob);
        day = Integer.parseInt(date[0]);
        month = Integer.parseInt(date[1]);
        year = Integer.parseInt(date[2]);
        while(s.hasNext()) {
            deptName = s.next();
            nextdeptName = s.next();
            deptMap.put(deptName, new Department(nextdeptName));
        }
         ceo = new Employee(name, id, sal, deptMap.get(deptName), new Date(year, month - 1, day));
         System.out.println("CEO : " +ceo.getEname());
         System.out.println("CEO dob:" + ceo.getDob());
         allEmployees.add(ceo);

        while (scn.hasNext()) {
            name = scn.next();
            id = scn.nextInt();
            sal = scn.nextDouble();
            deptName = scn.next();
            dob = scn.next();
             date = dateSplitter(dob);
            day = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            year = Integer.parseInt(date[2]);

            Employee e = new Employee(name, id, sal, deptMap.get(deptName), new Date(year, month - 1, day) );
            int mid = scn.nextInt();

            Employee manager = getManager(mid);
            allEmployees.add(e);
           // e.deptName = deptName;
            manager = manager;
            if (manager != null ) {
                manager.alldirectrepotiees.add(e);   // Adding directRepotiees to their respective manager
            }


        }
    }
    public String[] dateSplitter(String date) {
        String[] all = date.split("/");
        return all;
    }

    public String getCmpname() {
        return cmpname;
    }
    public String getCmpurl() {
        return cmpurl;
    }

    public Employee getManager(int managerId) {               // To get find manager for given emplyee
       // System.out.println("Looking for manager of : " + managerId);
       // System.out.println("allEmployees.size(): " +allEmployees.size());
        for (int i = 0; i < allEmployees.size(); i++ ) {
            Employee e = allEmployees.get(i);
           // System.out.println("Emp : " + e);
            if (managerId == e.getEmpid()) {
                return e;
            }
        }
       System.out.println("Could not find manager for the given id: " + managerId);
        return null;
    }

    public static void main(String[] args) {
        if (args.length >= 2 ) {
            try {
                Employee emp;
                Employee e;
                Scanner sc = new Scanner(new File(args[0]));
                Scanner sc1 = new Scanner(new File(args[1]));
                Scanner sc2 = new Scanner(new File(args[2]));
                Company c = new Company();
                //Company cmpDetails = c.companyDetails(sc,sc1, sc2);
                c.companyDetails(sc, sc1,  sc2);
                c.printAllDirectRepotiees(c.allEmployees);
                emp = c.getMaxAge(c.allEmployees);
               System.out.println(emp.getEname() + " has maximum age");
                e = c.getLongestHod(c.allEmployees);
                System.out.println(e.getEname() + "has longest chain");


            } catch(FileNotFoundException nfe) {
                System.err.println(nfe);
            }
            //  c.printcompanyDetails(cmpDetails);

        } else {
            System.out.println("\n please enter  2 file names as argument");
        }
    }

    public void printAllDirectRepotiees(List<Employee> allEmployees) {
        for (Employee e : allEmployees) {
            if (e.alldirectrepotiees != null) {
                System.out.println(e.alldirectrepotiees.size() + "and" + e.getEname() );
            }
            else {
                System.out.println(e.getEname() + "don't have direct repotiees");
            }
       }
    }

    public int getDepthofManager(Employee e) {
        int depth = 0;
        int dept1 = 0;
        int count = 0;
        if(e.alldirectrepotiees != null) {
            depth++;
        for (Employee emp  : e.alldirectrepotiees) {
                dept1 = getDepthofManager(emp);
                if (count < dept1) {
                    count = dept1;
            }
        }
      }
        return count + 1;
    }
    public Employee getLongestHod(List<Employee> allEmployees) {
       Employee ceo = allEmployees.get(0);
       Employee emp = null;
       int count = 0;
      for ( Employee e : ceo.alldirectrepotiees) {
            int length = getDepthofManager(e);
            if ( count < length) {
               count = length;
               emp = e;
            }
       }
      return emp;
    }
    public Employee getMaxAge(List<Employee> allEmployees) {

            Employee emp = allEmployees.get(0);
            for (int j = 1; j< allEmployees.size() ; j++ ) {
                Employee nextEmp = allEmployees.get(j);
                System.out.println(nextEmp.getEname());
                System.out.println(nextEmp.getDob());
                if ((emp.getDob().compareTo(allEmployees.get(j).getDob())) < 0) {
                    emp = nextEmp;
                 }
             }
             return emp;


    }
}
