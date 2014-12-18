import java.util.*;
import java.io.*;
class Company {
    List<Department> allDept = new ArrayList<Department>();
    String cmpName;
    String url;
    Company() {
    }
    public static void compInfo(Scanner sc , String deptCalculate) {
        Company cmp = new Company();
        cmp.cmpName = sc.next();
        cmp.url = sc.next();
        int no_of_dept = sc.nextInt();
        System.out.println(cmp.cmpName + " " + cmp.url);
        for(int i = 0; i < no_of_dept; i++) {
            cmp.allDept.add(Department.deptInfo(sc));
        }
        for(Department d : cmp.allDept) {
            System.out.println(d.deptName);
            if(deptCalculate.equals(d.deptName)) {
                System.out.println(d.deptName);
                cmp.findLongestChain(d.allEmp , d.no_of_employees);
                break;
            }
        }
    }
    public void findLongestChain(List<Employee> allEmpList , int index1) {
        int id , mnid=0 , cnt , cnt1 = 0 , longId =0;
        for(Employee e : allEmpList) {
            id = e.empId;
            cnt = 0;
            label1:
            for (int j = 0; j < index1 ; j++) {
                if(id == allEmpList.get(j).mgrId) {
                    if(j < index1 - 1) {
                        id = allEmpList.get(j+1).empId;
                    }
                    cnt++;
                    mnid = allEmpList.get(j).mgrId;
                    continue label1;
                }
            }
            System.out.println();
            if(cnt1 <= cnt) {
                cnt1 = cnt;
                longId = mnid;
                System.out.print("longid" + longId + " " + cnt1);
            }
        }
        System.out.println(longId);
    }

}
class Department {
    List<Employee> allEmp = new ArrayList();
    String deptName;
    String hod;
    int no_of_employees;
    Department() {
    }
    public static Department deptInfo(Scanner sc) {
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
    public static void main(String[] args) throws FileNotFoundException , IOException{
        Scanner sc = new Scanner(new File("company.txt"));
        Company comp = new Company();
        System.out.println("enter the department you want to calculate");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        String deptCalculate = reader.readLine();
        comp.compInfo(sc , deptCalculate);
    }
}
