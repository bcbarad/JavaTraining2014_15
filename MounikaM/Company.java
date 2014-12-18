import java.util.List;
import java.util.*;
import java.io.*;


public class Company {
    String companyName;
    String url;
    List<Deportment> depts;
    //Employee ceo;

    public Company() {
    }
    public List<Deportment> enteringvaluestoArray(List<Deportment> depts, Scanner sc) {
       // int ceoid = sc.nextInt();

        String cmpname = sc.next();
        String url = sc.next();
        int noofDepartments = sc.nextInt();
        String name;
        String hod;
        List<Employee> emp;
        Deportment d = new Deportment();

        while(noofDepartments != 0) {

            name = sc.next();
            hod = sc.next();
            emp = d.enteringvaluestoArrayList(sc);
            depts.add(new Deportment(name, hod, emp));
            noofDepartments--;
        }
        return depts;
    }


    public static void main(String[] args)throws IOException {
        if (args.length == 1) {
            Scanner sc = new Scanner(new File(args[0]));
            List<Deportment> depts = new ArrayList<Deportment>();
            Company c = new Company();
            List<Deportment> deptm = c.enteringvaluestoArray(depts, sc);
            c.printCompanyDetails(deptm);
            Map<Integer, Employee> m = c.longestChain(deptm);
            Employee manager = c.getManager(m);

            System.out.println("\n Manager who has highest chain is :" + manager);
        } else {
            System.out.println("\n please enter command line argument length as one:");
        }
    }
    public void  printCompanyDetails(List<Deportment> dept ) {
        for (Deportment de : dept) {
            System.out.println("\n deportment name is : " + de.deportmentName + " head of deportment is " + de.headOfDeptName);
            for (Employee e : de.employees) {
                System.out.println("\n emloyee name : " + e.empname + "salary is " + e.salary + "employee id " + e.id + " magere id" + e.mid);
            }
        }
    }

    public Employee  getManager(Map<Integer, Employee> m)  {

        Integer i = 0;
        Set<Integer> keys = m.keySet();
        for (Integer k : keys) {
            if (i < k) {
                i = k;
            }
        }
        return m.get(i);
    }

    public Map<Integer, Employee> longestChain(List<Deportment> dept) {
        Map<Integer, Employee> map = new HashMap<Integer, Employee>();

        for (Deportment d : dept) {
            ListIterator<Employee> itr = d.employees.listIterator();
           // System.out.println(d);
            while (itr.hasPrevious()) {
                Integer count = 0;
                Employee e = itr.previous();
                System.out.println(e);
                int id = e.id;
                int mid = e.mid;
                while(itr.hasPrevious()) {
                    Employee e2 = itr.previous();
                    System.out.println(e2);
                    if (mid == e2.id) {
                        mid = e2.mid;
                        e = e2;
                        count ++;
                    }
                }
                map.put(count, e);
            }
           // System.out.println(map);
        }
        return map;
    }
}

class Deportment {
    String deportmentName;
    String headOfDeptName;
    List<Employee> employees;

    public Deportment() {
    }

    public Deportment(String deportmentName, String headOfDeportment, List<Employee> emp) {
        this.deportmentName = deportmentName;
        this.headOfDeptName = headOfDeportment;
        this.employees = emp;
    }
    public List<Employee> enteringvaluestoArrayList(Scanner sc) {
        String name;
        List<Employee> employees = new ArrayList<Employee>();
        int id;
        int mid;
        float salary;
        int noofEmployees = sc.nextInt();

        while(noofEmployees != 0) {
            name = sc.next();
            id = sc.nextInt();
            salary = sc.nextFloat();
            mid = sc.nextInt();
            employees.add(new Employee(name,id,salary,mid));
            noofEmployees--;
        }

        return employees;
    }
}
class Employee {
    String empname;
    int id;
    float salary;
    int mid;

    public Employee() { }

    public Employee(String name, int id, float sal, int mid) {
        this.empname = name;
        this.id = id;
        this.salary = sal;
        this.mid = mid;
    }
}


