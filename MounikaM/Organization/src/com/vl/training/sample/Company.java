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
   // public String[] allDepartments;

    public void companyDetails(Scanner sc, Scanner scn) {
                                                                       // To read company and employee details.
        String name = null;
        int id = 0;
        double sal;
        int i = 0;
        String deptName = null;
        //Company cmp = new Company();
        Employee emp = new Employee();
        // Department d = new Department();
        cmpname = sc.next();
        cmpurl = sc.next();
        name = sc.next();
        id = sc.nextInt();
        sal = sc.nextDouble();
        ceo = new Employee(name, id, sal);
        System.out.println("CEO : " +ceo);
        allEmployees.add(ceo);

     /*   while(s.hasNext()) {
            allDepartments[i] = sc.next();
            i++;
        }*/

        while (scn.hasNext()) {
            name = scn.next();
            id = scn.nextInt();
            sal = scn.nextDouble();
           // deptName = scn.next();

            Employee e = new Employee(name, id, sal);
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
                Scanner sc = new Scanner(new File(args[0]));
               // Scanner sc1 = new Scanner(new File(args[1]));
                Scanner sc2 = new Scanner(new File(args[2]));
                Company c = new Company();
                //Company cmpDetails = c.companyDetails(sc,sc1, sc2);
                c.companyDetails(sc, sc2);
                c.printAllDirectRepotiees(c.allEmployees);
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
            //if (e.allDirectrepotiees != null) {
                //depth++;
                dept1 = getDepthofManager(emp);
                if (count < dept1) {
                    count = dept1;
            }
        }
      }
        return count + 1;
    }

   /* public Map<String Employee> findHeadofDepartments(List<Employee> allEmployees, String[] allDepartments) {
        for (int i = 0; i < allDepartments.size; i++) {
             for (Employee e : allEmployees) {
                 if (allDepartments[i].equals(e.getdeptName()) && e.*/
}
