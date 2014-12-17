//package com.vl.training.sample;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class CompanyList {
    public static void main(String[] args) {
        String name;
        Scanner sc = new Scanner(System.in);
        ArrayList<DepartmentList> dlist = new ArrayList();
        CompanyList c = new CompanyList();
        DepartmentList dl = new DepartmentList();
        System.out.println("Enter no of departments");
        int noofdepartments = sc.nextInt();
        for (int i = 0; i < noofdepartments; i++) {
            DepartmentList d = new DepartmentList();
            DepartmentList d1 = d.getDepartmentList(sc);
            System.out.println("check"+dlist.add(d1));
        }
        System.out.println("enter ceo id");
        int ceoid ;
        ceoid = sc.nextInt();
        //void Longest();
       // d.Longest(dlist,noofdepartments)
        //Iterator<DepartmentList> i = dlist.iterator();
        //while(i.hasNext()) {
           // dl = (DepartmentList)i.next();
           int count = 0;
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
        return count;
    }
}
class DepartmentList {
    String name,hodname;
    ArrayList<EmployeeList> elist;
    int noofemployees;
    DepartmentList d;
    public DepartmentList getDepartmentList(Scanner sc) {
        d = new DepartmentList();
        System.out.println("Enter deptname and hodname");
        d.elist = new ArrayList();
        d.name = sc.next();
        d.hodname = sc.next();
        System.out.println("Enter no of Employees");
        d.noofemployees = sc.nextInt();
        for (int i = 0; i < d.noofemployees; i++) {
            EmployeeList e = new EmployeeList();
            EmployeeList e1 = e.getEmployee(sc);
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
class EmployeeList {
    int eid,salary,managerid;
    String name;
    EmployeeList e;
    public EmployeeList getEmployee(Scanner sc) {
        e = new EmployeeList();
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
