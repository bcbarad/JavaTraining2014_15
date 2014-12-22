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
class Department {
    List<Employee> allEmp = new ArrayList();
    private String deptName;
    private String hod;
    private int no_of_employees;
    Department() {
    }
    public static Department deptInfo(final Scanner sc) {
        Department d = new Department();
        d.deptName = sc.next();
        d.hod = sc.next();
        d.no_of_employees = sc.nextInt();
        for (int i = 0; i < d.no_of_employees; i++) {
            d.allEmp.add(Employee.empInfo(sc));
        }
        return d;
    }
}
