package company.code;
import java.util.*;
import java.io.*;
public class Department {
    String department_name;
    int head_of_depart , depart_id ;
    ArrayList<Employee> allemployees;
    public static Department getDepartData(Scanner sc) {
        Department departobj = new Department();
        departobj.department_name = sc.next();
        departobj.head_of_depart = sc.nextInt();
        departobj.allemployees = new ArrayList<Employee>();
        int no_of_employees = sc.nextInt();
        for (int i = 0; i < no_of_employees; i++) {
            departobj.allemployees.add(Employee.getEmployeeData(sc));
        }
        return departobj;
    } 
    
}
