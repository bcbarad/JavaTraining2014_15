import java.util.List;
import java.util.ArrayList;


public class Company {
    private String companyName;
    private String url;
    List<Deportment> dept;

    public Company(String companyName, Strin url, List<Deportment> dept) {
        this.companyName = companyName();
        this.url = url;
        this.dept = dept;
    }
}

public class Deportment {
    String deportmentName;
    String headOfDeptName;
    List<Employee> employee;

    public Deportment(String deportmentName, String headOfDeportment, List<Employee> emp) {
        this.deportmentName = deportmentName;
        this.headOfDeportment = headOfDeportment;
        this.employee = emp;
    }
    public List<Employee> enteringvaluestoArrayList(List<Employee> employee) {
        String name;
        int id,mid;
        float salary;
       // SimpleDateFormat date;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        while(!flag) {
            System.out.println("\n eneter emp name:");
            name = sc.next();
            System.out.println("\n enetr emp id:");
            id = sc.nextInt();
            System.out.println("\n enetr salary:");
            salary = sc.nextFloat();
            System.out.println("\n enetr managed id:");
            mid = sc.nextInt();
            employee.add(new Employee(name,id,salary,mid));

            System.out.println("\n enetr yes or no:");
            String s = sc.next();
            if(s.equals("no") {
                    flag = true;
            }
        }


    }
}
class Employee {
    String empname;
    int id;
    float salary;
    int managerId;
//    SimpleDateFormat date;

    public Employee(String name, int id, float sal,int mid,SimpleDateFormat date) {
        this.empname = name;
        this.id = id;
        this.salary = sal;
        this.managedid = mid;
        this.date  = date;
    }
}
