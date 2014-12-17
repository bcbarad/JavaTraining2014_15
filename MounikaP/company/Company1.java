import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
public class Company1 {
    public static void main(String args[]) {
        try {
            if (args.length == 1) {
                Scanner sc = new Scanner(new File(args[0]));
                Company1 c = new Company1();
                List<Department> d = c.departmentDetails(sc);
            } else {
                System.out.println("pass file name as arguments");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    String name;
    String url;
    List<Department> dd;
    public Company1() {
    }
    public Company1(String name, String url) {
        this.name = name;
        this.url = url;
    }
    public static List<Department> departmentDetails(Scanner sc) {
        String deptName, deptHead;
        Department d = new Department();
        String name = sc.next();
        String url = sc.next();
        int deptCount = sc.nextInt();
        List<Employee> emp;
        //emp = d.employeeDetails(sc);
        List<Department> dlist = new ArrayList();
        while (deptCount >= 0) {
            deptName = sc.next();
            deptHead = sc.next();
            dlist.add(new Department(deptName, deptHead/*, emp)*/));
            deptCount--;
        }
        //return dlist;
        emp = d.employeeDetails(sc);
        return dlist;
    }
}
class Employee {
    int empId, empSal, empCount, empAge;
    String empName;
    public Employee() {
    }
    public Employee(String empName, int empId, int empSal, int empAge) {
        this.empName = empName;
        this.empId = empId;
        this.empSal = empSal;
        this.empAge = empAge;
    }
}
class Department {
    String deptName;
    String deptHead;
    int deptCount;
    public Department() {
    }
    List<Employee> employee;
    public Department(String deptName, String deptHead /*List<Employee> e*/) {
        this.deptName = deptName;
        this.deptHead = deptHead;
        //this.employee = e;
    }
    public static List<Employee> employeeDetails(Scanner sc) {
        List<Employee> elist = new ArrayList();
        int empCount = sc.nextInt();
        while (empCount >= 0) {
            String empName = sc.next();
            int empId = sc.nextInt();
            int empSal = sc.nextInt();
            int empAge = sc.nextInt();
            elist.add(new Employee(empName, empId, empSal, empAge));
            empCount--;
        }
        return elist;
    }
}

