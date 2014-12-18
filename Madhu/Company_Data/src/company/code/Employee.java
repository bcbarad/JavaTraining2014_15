package company.code;
import java.util.*;
import java.io.*;
public class Employee {
    int emp_id , manager_id , emp_age;
    String emp_name;
    double emp_salary;
    public static Employee getEmployeeData(Scanner sc) {
        Employee empobj = new Employee();
        empobj.emp_name = sc.next();
        empobj.emp_id = sc.nextInt();
        empobj.emp_salary = sc.nextDouble();
        empobj.manager_id = sc.nextInt();
        empobj.emp_age = sc.nextInt();
        return empobj;
    }
}
