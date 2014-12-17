package company.code;
import java.util.*;
import java.io.*;
public class CompanyInfo12 {
    Company companydata = new Company();
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("please provide the required arguments ");
        } else {
            Scanner sc = new Scanner(new File(args[0]));
            CompanyInfo12 cominfo = new CompanyInfo12();
            cominfo.companydata = Company.getCompanyData(sc);
            String department_name =  sc.next();
            Employee long_emp = CompanyInfo12.getLongChainId(department_name , cominfo , cominfo.companydata);     
            System.out.println("the longet chain employee details: name--" + long_emp.emp_name +  "--employee id-- " + long_emp.emp_id + "--salary-- " + long_emp.emp_salary);
        }
    }
    public static Employee  getLongChainId(String department_name , CompanyInfo12 cominfo1 , Company comobj) {
        int long_id = 0 , depart_index = 0;
        Employee long_emp;
        for (int i = 0; i < cominfo1.companydata.alldepartments.size(); i++) {
            if (department_name.equals(cominfo1.companydata.alldepartments.get(i).department_name)) {
                depart_index = i;
            }
        }
        long_emp = Department.getLongEmployee(depart_index , comobj);
        return long_emp;
    }
}
class Company {
    String companyname;
    String url;
    ArrayList<Department> alldepartments;
    public static Company getCompanyData(Scanner sc) {
        Company compobj = new Company();
        compobj.companyname = sc.next();
        compobj.url = sc.next();
        compobj.alldepartments = new ArrayList<Department>();
        int no_of_departments = sc.nextInt();
        for (int i = 0; i < no_of_departments; i++) {
            compobj.alldepartments.add( Department.getDepartData(sc));
        }
        return compobj;
    }
    
}
class Department {
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
    public static Employee getLongEmployee(int index ,Company compobj) {
        int long_id = 0 ,count1 = 0, id = 0 ,index1 = 0;
         for (int i = 0; i < compobj.alldepartments.get(index).allemployees.size(); i++) {
            int count = 0;
            id = compobj.alldepartments.get(index).allemployees.get(i).emp_id;
            count++;
            lable1:
            for (int j = 0; j < compobj.alldepartments.get(index).allemployees.size(); j++) {
                if(compobj.alldepartments.get(index).allemployees.get(j).manager_id == id) {
                    id = compobj.alldepartments.get(index).allemployees.get(j).emp_id; 
                    count++;
                    continue lable1;
                }
            } 
            if (count1 <= count)
            {
                count1 = count;
                long_id = compobj.alldepartments.get(index).allemployees.get(i).manager_id;
            }
            if ((compobj.alldepartments.get(index).allemployees.get(i).emp_id) == long_id ) {
                index1 = i;
            }
        }
        System.out.println(long_id);
        return compobj.alldepartments.get(index).allemployees.get(index1);
    }
}
class Employee {
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
