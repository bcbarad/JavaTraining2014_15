package company.code;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Employee {
    public int empid;
    public int empsalary;
    public int empmanagerid;
    public String empname;
    public Date empdob;
    public static  Employee getEmployee(Scanner sc) {     // method to get the employee details
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Employee empobj = new Employee();
        empobj.empid = sc.nextInt();
        empobj.empsalary = sc.nextInt();
        empobj.empmanagerid = sc.nextInt();
        empobj.empname = sc.next();
        try {
            empobj.empdob = sdf.parse(sc.next());
        } catch (Exception pe) {
            System.out.print(pe);
        }
        return empobj;
    }
}
