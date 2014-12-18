package com.vl.training.sample;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
public class CompanyInfo {
    public static void main(String[] args) throws FileNotFoundException {
        CompanyInfo cinfo = new CompanyInfo();
        Scanner sc = new Scanner(new File(args[0]));
        Company c = new Company();
        Company cc = c.companyDetails(sc);
        c.longestChain(cc);
    }
}
class Company {    
    String name;
    int ceoid;
    ArrayList<Department> dlist;
    Company c;
    int noofdepartments;
    public Company companyDetails(Scanner sc) {
        c = new Company();
        c.dlist = new ArrayList();
        Department dl = new Department();
        c.noofdepartments = sc.nextInt();
        for (int i = 0; i < c.noofdepartments; i++) {
            Department d = new Department();
            Department d1 = d.getDepartment(sc);
            c.dlist.add(d1);
        }
        return c;
    }
    public void longestChain(Company c) {
          Department d;
          Employee e;
          for (int j = 0; j < c.dlist.size(); j++) {
              d = c.dlist.get(j);
              for (int k = 0; k < d.elist.size(); k++) {
                  e = d.elist.get(k);
                  /*int count =*/ searchReporties(e.eid,c,j,0);
                  //System.out.println("count is "+count);
              }
          }
    }
    public void searchReporties(int empid,Company c,int j,int count) {
        Department d;
        Employee e;
        for (; j < c.dlist.size(); j++) {
            d = c.dlist.get(j);
            for (int k = 0; k < d.elist.size(); k++) {
                e = d.elist.get(k);
                if ( e.eid == empid ) {
                    count++;
                    System.out.print(e.eid+"-->");
                    searchReporties(e.managerid, c,j,count);                   
                    System.out.print("\n");                  
                    break;
                 }
             } 
            break;
        }
    }
}
class Department {
    String name,hodname;
    ArrayList<Employee> elist;
    int noofemployees;
    Department d;
    public Department getDepartment(Scanner sc) {
        d = new Department();
         d.elist = new ArrayList();
        d.name = sc.next();
        d.hodname = sc.next();
        d.noofemployees = sc.nextInt();
        for (int i = 0; i < d.noofemployees; i++) {
            Employee e = new Employee();
            Employee e1 = e.getEmployee(sc);
            d.elist.add(e1);
        }
        return d;
    }
}
class Employee {
    int eid,salary,managerid;
    String name;
    Employee e;
    public Employee getEmployee(Scanner sc) {
        e = new Employee();
        e.eid = sc.nextInt();
        e.salary = sc.nextInt();
        e.managerid = sc.nextInt();
        e.name = sc.next();
        return e;
    }
    public int getempmanagerid() {
        return e.managerid;
    }
}
