package com.vl.training.sample;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Company {
    String cname;
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
        int deptcount=0;
        String deptName = null;
        int mgrid = 0, highempindex=0, highdeptempindex=0;
        //checking for each and every department and get overall employee who is having longest chain
        for (int j = 0; j < c.dlist.size(); j++) {
            d = c.dlist.get(j);
            int emphighestcount = 0;
        //checking for particular department and their employees and get longestchain of employee in particular department
            for (int k = 0; k < d.elist.size(); k++) {
                e = d.elist.get(k);
                int empcount = searchReporties(e.managerid,c,j,0);
                if (empcount > emphighestcount) {
                    emphighestcount = empcount;
                     highempindex=k;
                }
            }
            if (deptcount<=emphighestcount) {
                deptcount=emphighestcount;
                highdeptempindex=highempindex;
                deptName = c.dlist.get(j).name;
                mgrid = d.elist.get(highdeptempindex).managerid;

            }

        }
        System.out.println("higest dept count is: "+deptcount +" with in the department:  " + deptName+" with Manager id:  "+mgrid);
    }
    public int searchReporties(int managerid,Company c,int j,int count) {
        Department d;
        Employee e;
        for (; j < c.dlist.size(); j++) {
            d = c.dlist.get(j);
            for (int k = 0; k < d.elist.size(); k++) {
                e = d.elist.get(k);
                if (e.managerid == managerid) {
                    // increase current depth by 1 and then find new depth for all the reporting team.
                    count = searchReporties(e.eid, c,j,count+1);
                    break;
                }
            }
            break;
        }
        return count;
    } 
    public void getHighestAge(Company c) {
        Date depathighage = new Date("19/12/2014");
        int eeid=0;
        for (int j=0; j < c.dlist.size(); j++) {
            Department d = c.dlist.get(j);
            Date highempage = null;
            int highageempid=0;
            Employee e = d.elist.get(0);
            for (int k = 1; k < d.elist.size(); ) {
                Employee e1 = d.elist.get(k++);
                int a = e.dob.compareTo(e1.dob);
                if ( a == -1) {
                    e = d.elist.get(k-2);
                } else if( a==1) {
                    e = d.elist.get(k-1);
                } else { 
                    e = d.elist.get(k-1);
                }
            }
            highempage = e.dob;
            highageempid = e.eid;
            System.out.println("The highest employee id who has a highest age: "+highempage+"id"+highageempid);
            int b = depathighage.compareTo(highempage);
            if (b == 1) {
                depathighage = highempage;
                eeid = highageempid;
//                       System.out.println(depathighage);  
            }                     
        }
        System.out.println("total highest age is "+depathighage+ "id "+eeid); 
   }
}
