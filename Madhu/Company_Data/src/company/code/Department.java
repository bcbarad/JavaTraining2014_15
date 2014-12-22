package company.code;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Department {
    public String deptname,depthodname;
    public ArrayList<Employee> allEmployees;
    private int noofemployees;
    public static Department getDepartment(Scanner sc) {    // method to get the department details
        Department departobj = new Department();
        departobj.allEmployees = new ArrayList();
        departobj.deptname = sc.next();
        departobj.depthodname = sc.next();
        departobj.noofemployees = sc.nextInt();
        for (int i = 0; i < departobj.noofemployees; i++) {
            Employee e = new Employee();
            Employee e1 = Employee.getEmployee(sc); // call the method to get each employee details
            departobj.allEmployees.add(e1);
        }
        return departobj;
    }
}
