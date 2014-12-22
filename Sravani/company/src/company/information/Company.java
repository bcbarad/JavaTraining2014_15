package company;
package company.information;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Company {
    List<Department> allDept = new ArrayList<Department>();
    private String cmpName;
    private String url;
    Company() {
    }
    public static void compInfo(final Scanner sc) {
        Company cmp = new Company();
        cmp.cmpName = sc.next();
        cmp.url = sc.next();
        int no_of_dept = sc.nextInt();
        System.out.println(cmp.cmpName + " " + cmp.url);
        for(int i = 0; i < no_of_dept; i++) {
            cmp.allDept.add(Department.deptInfo(sc));
        }
    }
    public void longestChain(final Company c) {
        Department d;
        Employee e;
        int deptcount = 0;
        String deptName = null;
        int tempMgrId = 0;
        int highEmpIndex = 0;
        int  highDepTempIndex = 0;
        // finding the highest chain of the departments
        for (int j = 0; j < c.allDept.size(); j++) {
            d = c.allDept.get(j);
            int empHighestCount = 0;
            // finding the highest chain of employees for individual department
            for (int k = 0; k < d.allEmp.size(); k++) {
                e = d.allEmp.get(k);
                int empCount = searchReporties(e.mgrId , c , j , 0);
                if (empCount > empHighestCount) {
                    empHighestCount = empCount;
                    highEmpIndex = k;
                }
            }
            // end of checking for the employees and started for the departments
            if (deptcount <= empHighestCount) {
                deptcount = empHighestCount;
                highDepTempIndex = highEmpIndex;
                deptName = d.deptName;
                tempMgrId = d.allEmp.get(highDepTempIndex).mgrId;
            }
        }
        System.out.println("higest dept count is: " + deptcount  + " with in the department:  " + deptName + " with Manager id:  " + tempMgrId);
    }
    // searches for reporty in order to find the depth of highest manager position
    public int searchReporties(final int managerid,final Company c,final int j,final int count) {
        Department d;
        Employee e;
        for (; j < c.allDept.size(); j++) {
            d = c.allDept.get(j);
            for (int k = 0; k < d.allEmp.size(); k++) {
                e = d.allEmp.get(k);
                if (e.mgrId == managerid) {
                    // increase current depth by 1 and then find new depth for all the reporting team.
                    count = searchReporties(e.empId, c,j,count+1);
                    break;
                }
            }
            break;
        }
        return count;
    }
    // finding the age of highest employee in the company
    public void getHighestAge(final Company c) {
        Date depathighage = new Date("19/12/2014");
        Date highEmpAge;
        int highAgeEmpid;
        int eeid=0;
        // finding the age of highest employee in the departemnt
        for (int j=0; j < c.allDept.size(); j++) {
            Department d = c.allDept.get(j);
            highEmpAge = null;
            highAgeEmpid=0;
            Employee e = d.allEmp.get(0);
            for (int k = 1; k < d.allEmp.size(); k++ ) {
                Employee e1 = d.allEmp.get(k);
                int a = e.dob.compareTo(e1.dob);
                if( a==1) {
                    e = e1;
                }
            }
            // finding the highest age in the company
            highEmpAge = e.dob;
            highAgeEmpid = e.empId;
            System.out.println("The highest employee id who has a highest age: "+highEmpAge+"id"+highAgeEmpid);
            int b = depathighage.compareTo(highEmpAge);
            if (b == 1) {
                depathighage = highEmpAge;
                eeid = highAgeEmpid;
            }
        }
        System.out.println("total highest age is "+depathighage+ "id "+eeid);
    }
}
