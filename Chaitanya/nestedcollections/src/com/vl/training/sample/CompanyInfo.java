//package com.vl.training.sample;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class CompanyInfo {
    public static void main(String[] args) {
//        System.out.println("hai");
        CompanyInfo cinfo = new CompanyInfo();
        Scanner sc = new Scanner(System.in);
//        System.out.println("hai");
        Company c = new Company();
//        System.out.println("hai");
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
//        System.out.println("hai");
        c = new Company();
        //Scanner sc = new Scanner(System.in);
        c.dlist = new ArrayList();
//        System.out.println("hai");

//        c = new Company();

        Department dl = new Department();
        System.out.println("Enter no of departments");
        c.noofdepartments = sc.nextInt();
        for (int i = 0; i < c.noofdepartments; i++) {
            Department d = new Department();
            Department d1 = d.getDepartment(sc);
            System.out.println("hello");
            System.out.println("check"+c.dlist.add(d1));
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
                  searchReporties(e.eid,e);
                 // System.out.println(e.eid);
              }
          }
                 // SearchReporties(e.empid)
          //System.out.println( d);
          //System.out.println( e);
          //System.out.println( e.managerid);
    }
    public void searchReporties(int empid,Employee e) {
        if ( e.eid == empid ) {
            System.out.println(e.eid+"-->");
            searchReporties(e.managerid, e);
        }
        else {
            System.out.println("\n");
        }
    }
}
       // System.out.println("enter ceo id");
       // int ceoid ;
       // ceoid = sc.nextInt();
        //void Longest();
       // d.Longest(dlist,noofdepartments)
        //Iterator<DepartmentList> i = dlist.iterator();
        //while(i.hasNext()) {
           // dl = (DepartmentList)i.next();
       /*    int count = 0;
           for ( int j = 0; j < dlist.size(); j++) {
               for ( int k = 0; k < dlist.get(j).elist.size(); k++) {
                    count = c.longest(dlist.get(j).elist.get(k).eid,0,ceoid,dlist);
               }
           }
           System.out.println("count is"+count);
    }
    int longest(int empid, int count,int ceoid,ArrayList<DepartmentList> dlist) {
        //   System.out.println("Enter empid");
        //int empid = sc.nextInt();
        for (int j = 0; j < dlist.size(); j++) {
            for ( int k = 0; k < dlist.get(j).elist.size(); k++ ) {
                if (dlist.get(j).elist.get(k).eid == empid) {
                    count++;
                    longest(dlist.get(j).elist.get(k).managerid,count,ceoid,dlist);
                    //System.out.println( dlist.get(j).elist.get(k).managerid);
                }
                //System.out.println(dlist.get(j).elist.size());
               // System.out.println(dlist.get(j).elist.get(0).eid);
            }
        }
        return count;*/
  //  }
//}
class Department {
    String name,hodname;
    ArrayList<Employee> elist;
    int noofemployees;
    Department d;
    public Department getDepartment(Scanner sc) {
        d = new Department();
        System.out.println("Enter deptname and hodname");
        d.elist = new ArrayList();
        d.name = sc.next();
        d.hodname = sc.next();
        System.out.println("Enter no of Employees");
        d.noofemployees = sc.nextInt();
        for (int i = 0; i < d.noofemployees; i++) {
            Employee e = new Employee();
            Employee e1 = e.getEmployee(sc);
            System.out.println("Hello"+d.elist.add(e1));
        }
       /* Iterator i = elist.iterator();
        while(i.hasNext()) {
            EmployeeList l = (EmployeeList)i.next();
            System.out.println("helllo"+l.salary);
        }*/
        return d;
    }
   /* public void longest(ArrayList<DepartmentList> dlist, int noofdepartments) {
        for ( int j = 0 ; j <noofdepartments; j ++) {
            for ( int k = 0; k <
    }*/
}
class Employee {
    int eid,salary,managerid;
    String name;
    Employee e;
    public Employee getEmployee(Scanner sc) {
        e = new Employee();
        System.out.println("Enter eid ,salary, managerid and name");
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
