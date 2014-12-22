package com.vl.training.sample;
import java.util.*;
import java.io.*;
public class Company {
    String cname;
    String url;
    int nodept;
    int ceo_id;
    List<Department> alldepartments;
    public static void main(final String[] args) throws Exception {
        Scanner sc = new Scanner(new File(args[0]));
        Company c = new Company();
        Company companydata = c.getCompany(sc);
        String Department_name = sc.next();
        int deptindex = c.getCompanyIndex(Department_name, companydata);
        Employee e = getlongIdandEmpdetails(deptindex , companydata);
        System.out.println("the employee who has longest chain:");
        System.out.println("Empname     Empid     Empsal");
        System.out.println(e.ename + "\t" + e.eid + "\t" + e.sal);
    }
    public Company getCompany(final Scanner sc) {
        Company c = new Company();
        c.cname = sc.next();
        c.url = sc.next();
        c.ceo_id = sc.nextInt();
        c.nodept = sc.nextInt();
        c.alldepartments = new ArrayList<Department>();
        for (int i = 0; i < c.nodept; i++) {
            c.alldepartments.add(Department.getDepartment(sc));
        }
        return c;
    }
    public static int getCompanyIndex(final String Department_name, final Company companydata) {
        int dept_index = 0;
        Company c = new Company();
        for (int i = 0; i < companydata.alldepartments.size(); i++) {
            if (Department_name.equals(companydata.alldepartments.get(i).dname)) {
                dept_index = i;
            }
        }
        //System.out.println(dept_index);
        return dept_index;
    }
    public static Employee getlongIdandEmpdetails(final int deptindex , final Company companydata) {
        int longid = 0, count1 = 0, id = 0, index1 = 0;
        for (int i = 0; i < companydata.alldepartments.get(deptindex).allemployees.size(); i++) {
            int count = 0;
            id = companydata.alldepartments.get(deptindex).allemployees.get(i).eid;
            count++;
            lable1:
            for (int j = 0; j < companydata.alldepartments.get(deptindex).allemployees.size(); j++) {
                if (companydata.alldepartments.get(deptindex).allemployees.get(j).mngr_id == id) {
                    id = companydata.alldepartments.get(deptindex).allemployees.get(i).eid;
                    count++; 
                    continue lable1; 
                }
            
            }
            if (count1 < count) {
                count1 = count;
                longid = companydata.alldepartments.get(deptindex).allemployees.get(i).mngr_id;
            }
            if ((companydata.alldepartments.get(deptindex).allemployees.get(i).eid) == longid) {
                index1 = i;
            }
        }
        return companydata.alldepartments.get(deptindex).allemployees.get(index1);
    }
}
class Department {
    String dname;
    String dhod;
    int noemp;
    List<Employee> allemployees;
    public static Department getDepartment(final Scanner sc) {
        Department d = new Department();
        d.dname = sc.next();
        d.dhod = sc.next();
        d.noemp = sc.nextInt();
        d.allemployees = new ArrayList<Employee>();
        for (int i = 0; i < d.noemp; i++) {
            d.allemployees.add(Employee.getEmployee(sc));
        }
        return d;
    }
}
class Employee {
    String ename;
    int eid;
    float sal;
    int mngr_id;
    public static Employee getEmployee(final Scanner sc) {
        Employee e = new Employee();
        e.ename = sc.next();
        e.eid = sc.nextInt();
        e.sal = sc.nextInt();
        e.mngr_id = sc.nextInt();
        List<Employee> alldirectreporters;
        return e;
    }
    public int getManager() {
        return mngr_id;
    }
}
