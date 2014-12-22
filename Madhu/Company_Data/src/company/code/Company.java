package company.code;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Company {
    private String company_name;
    private String url;
    private String ceo_name;
    public ArrayList<Department> alldepartments;
    private int no_of_departments;
    public static Company getCompanyDetails(Scanner sc) {   // method reads the company details
        Company compobj = new Company();
        compobj.company_name = sc.next();
        compobj.url = sc.next();
        compobj.ceo_name = sc.next();
        compobj.alldepartments = new ArrayList();
        compobj.no_of_departments = sc.nextInt();
        for (int i = 0; i < compobj.no_of_departments; i++) {
            Department departobj1 = new Department();
            departobj1= Department.getDepartment(sc);          // call the method to get each department details
            compobj.alldepartments.add(departobj1);
        }
        return compobj;
    }
    public static  void longestChain(Company companyobj) {     // method which gives the longest chain employee in the company
        Department departobj1;
        Employee empobj;
        int deptcount = 0;
        String deptName = null;
        int mgrid = 0;
        int  highempindex = 0;
        int  highdeptempindex = 0;
        for (int j = 0; j < companyobj.alldepartments.size(); j++) {
            departobj1 = companyobj.alldepartments.get(j);
            int emphighestcount = 0;
            for (int k = 0; k < departobj1.allEmployees.size(); k++) {
                empobj = departobj1.allEmployees.get(k);
                int empcount = companyobj.searchReporties(empobj.empmanagerid , companyobj , j , 0);    // call the method to get each employee depth
                if (empcount > emphighestcount) {
                    emphighestcount = empcount;
                    highempindex = k;
                }
            }
            if (deptcount <= emphighestcount) {
                deptcount = emphighestcount;
                highdeptempindex = highempindex;
                deptName = companyobj.alldepartments.get(j).deptname;
                mgrid = departobj1.allEmployees.get(highdeptempindex).empmanagerid;
            }
        }
        System.out.println("higest depth count is: " + deptcount + " with in the department:  " + deptName + " with Employee id:  " + mgrid);
    }
    public static int searchReporties(int managerid , Company companyobj , int j , int count) {     // method returns the depth of the each employee
        Department departobj2;
        Employee empobj1;
        for ( ; j < companyobj.alldepartments.size(); j++) {
            departobj2 = companyobj.alldepartments.get(j);
            for (int k = 0; k < departobj2.allEmployees.size(); k++) {
                empobj1 = departobj2.allEmployees.get(k);
                if (empobj1.empmanagerid == managerid) {
                    // increase current depth by 1 and then find new depth for all the reporting team.
                    count = searchReporties(empobj1.empid , companyobj , j , count+1);
                    break;
                }
            }
            break;
        }
        return count;
    }
    public static void getHighestAge(Company c) {         // method to get the highest age employee int the company and each department
        Date depathighage = new Date("19/12/2014");
        int eeid = 0;
        for (int j = 0; j < c.alldepartments.size(); j++) {
            Department departobj3 = c.alldepartments.get(j);
            Date highempage = null;
            int highageempid = 0;
            Employee empobj1 = departobj3.allEmployees.get(0);
            for (int k = 1; k < departobj3.allEmployees.size();k++ ) {
                Employee empobj2 = departobj3.allEmployees.get(k);
                int a = empobj1.empdob.compareTo(empobj2.empdob); // compare the date of birth of the two employees
                if( a== 1) {
                    empobj1 = empobj2;
                }
            }
            highempage = empobj1.empdob;
            highageempid = empobj1.empid;
            System.out.println("The highest age in the department :  " + departobj3.deptname + " employee id is: " + highageempid + " and date of birth is: " + highempage);
            int b = depathighage.compareTo(highempage);
            if (b == 1) {
                depathighage = highempage;
                eeid = highageempid;
            }
        }
        System.out.println(" highest age employeeid in the company is: " + eeid + " with date of birth: " + depathighage);
    }
}
