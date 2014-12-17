package com.vl.training.sample;
import java.util.*; 
import java.io.*;
public class Company {
    String cname;
    String url;
    int nodept;
    int ceo_id;
    List<Department> alldepartments;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File(args[0]));
        Company c = new Company();
        Object o = c.getCompany(sc).alldepartments.get(0).dname;
        System.out.println(o);
        String Department_name = sc.next(); 
        System.out.println(Department_name);
        int deptindex = c.getCompanyIndex(Department_name , sc);  
        System.out.println(deptindex);   
    }  
    public Company getCompany(Scanner sc) {
        Company c = new Company();
        c.cname = sc.next();
        c.url = sc.next();
        c.ceo_id = sc.nextInt();
        c.nodept = sc.nextInt();
        c.alldepartments = new ArrayList<Department>();
        for (int i = 0; i < c.nodept ; i++) {
            c.alldepartments.add(Department.getDepartment(sc));
        }
        return c;
    }
    public static int getCompanyIndex(String Department_name , Scanner sc) {
         int dept_index = 0;
         Company c = new Company();
         for (int i = 0; i < c.getCompany(sc).alldepartments.size(); i++) {
             if (Department_name.equals(c.getCompany(sc).alldepartments.get(i).dname))
                dept_index=i;
                System.out.println(dept_index);
         }
         return dept_index;
     }
}
class Department {
    String dname;
    String dhod;
    int noemp;
    List<Employee> allemployees;
    public static Department getDepartment(Scanner sc) {
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
    public static Employee getEmployee(Scanner sc) {
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
