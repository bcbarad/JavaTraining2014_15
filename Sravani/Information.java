import java.util.*;
import java.io.*;
class Company {
    List<Department> allDept = new ArrayList<Department>();
    String cmpName;
    String url;
    Company() {
    }
    public static void compInfo(Scanner sc) {
        Company cmp = new Company();
        cmp.cmpName = sc.next();
        cmp.url = sc.next();
        int no_of_dept = sc.nextInt();
        for(int i = 0; i < no_of_dept; i++) {
            cmp.allDept.add(Department.deptInfo(sc));
        }
    }
}
class Department {
    List<Employee> allEmp = new ArrayList();
     String deptName;
     String hod;
    Department() {
    }
    public static Department deptInfo(Scanner sc) {
        Department d = new Department();
        d.deptName = sc.next();
        d.hod = sc.next();
        int no_of_employees = sc.nextInt();
        for (int i = 0; i < no_of_employees; i++) {
            d.allEmp.add(Employee.empInfo(sc));
        }
    return d;
    }
}
class Employee {
    int empId;
    String empName;
    int sal;
    int mgrId;
    int age;
    Employee() {
    }
    public static Employee empInfo(Scanner sc) {
        Employee emp = new Employee();
        emp.empId = sc.nextInt();
        emp.empName = sc.next();
        emp.sal = sc.nextInt();
        emp.mgrId = sc.nextInt();
        emp.age = sc.nextInt();
    return emp;
    }
}
public class Information {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("company.txt"));
        Company comp = new Company();
        comp.compInfo(sc);
        //System.out.println(comp.cmpName);
    }
}
