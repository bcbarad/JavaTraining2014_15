package company;
package company.information;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Employee {
    private int empId;
    private String empName;
    private int sal;
    private int mgrId;
    private Date dob;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    Employee() {
    }
    public static Employee empInfo(final Scanner sc) {
        Employee emp = new Employee();
        emp.empId = sc.nextInt();
        emp.empName = sc.next();
        emp.sal = sc.nextInt();
        emp.mgrId = sc.nextInt();
        try {
            emp.dob = emp.sdf.parse(sc.next());
        } catch (Exception pe) {
            System.out.print(pe);
        }
        return emp;
    }
}
