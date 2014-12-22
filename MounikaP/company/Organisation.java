import java.io.*;
import java.util.*;
//import java.io.FileNotFoundException;
public class Organisation {
    //static Company com = new Company();
    public static void main(String args[]) {
        Company com = new Company();
        try {
            if (args.length == 1) {
                Scanner sc = new Scanner(new File(args[0]));
                //Organisation o = new Organisation();
                com = Company.companyDetails(sc);
            } else {
                System.out.println("pass file name as arguments");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Company {
    String name;
    String url;
    List<Department> allDepartments = new ArrayList<Department>();
    public static Company companyDetails(Scanner sc) {
        Company c = new Company();
        c.name = sc.next();
        c.url = sc.next();
        int deptCount = sc.nextInt();
        for (int i = 0; i < deptCount; i++) {
            c.allDepartments.add(Department.departmentDetails(sc));
        }
        return c;
    }
}
class Department {
    String deptName;
    String deptHead;
    int deptCount;
    List<Employee> allEmployees = new ArrayList<Employee>();
    public static Department departmentDetails(Scanner sc) {
        Department d = new Department(); 
        d.deptName = sc.next();
        d.deptHead = sc.next();
        int empCount = sc.nextInt();
        for (int i = 0; i < empCount; i++) {
            d.allEmployees.add(Employee.employeeDetails(sc));
        }
        return d;
    }
}
class Employee {
    int empId, empSal, empCount, empAge;
    String empName;
    public static Employee employeeDetails(Scanner sc) {
        Employee e = new Employee();
        e.empName = sc.next();
        e.empId = sc.nextInt();
        e.empSal = sc.nextInt();
        e.empAge = sc.nextInt();
        return e;
    }
}

