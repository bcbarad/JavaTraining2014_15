import java.util.*;
import java.io.*;
public class CompanyInfo12 {
        static Company companydata=new Company();
        public static void main(String[] args) throws FileNotFoundException {
           if(args.length !=1) {
                 System.out.println("please provide the required arguments ");
           } else {
                Scanner sc = new Scanner(new File(args[0]));
                CompanyInfo12 cominfo = new CompanyInfo12();
                cominfo.companydata = Company.getCompanyData(sc);
                String department_name =  sc.next();
                /*Employee  long_chain_emp = */CompanyInfo12.getLongChainId(department_name);   
                //System.out.println(long_chain_emp.emp_id);   
           }
        }
        public static /*Employee*/void  getLongChainId(String department_name) {
             int long_id=0 , depart_index=0; 
             Employee long_emp;
             for(int i=0; i < CompanyInfo12.companydata.department.size(); i++) {
                    if(department_name.equals(CompanyInfo12.companydata.department.get(i).department_name)) {
                           depart_index = i;
                          //System.out.println(depart_index);
                    }
              }
              /*long_emp = */Department.getLongEmployee(depart_index);
              //return long_emp;
        }
}
class Company {
    String companyname;
    String url;
    static ArrayList<Department> department;
    //int ceo_id;
    public static Company getCompanyData(Scanner sc) {
         Company compobj = new Company();
         compobj.companyname = sc.next();
         compobj.url = sc.next();
        // compobj.ceo_id = sc.nextInt();
         compobj.department = new ArrayList<Department>();
         int no_of_departments = sc.nextInt();
         for(int i=0;i<no_of_departments;i++) {
               compobj.department.add( Department.getDepartData(sc));
         }
         return compobj;
    } 
    
                       
}
class Department {
     String department_name;
     int head_of_depart,depart_id ;
     static ArrayList<Employee> employee;
     public static Department getDepartData(Scanner sc) {
          Department departobj = new Department();
          departobj.department_name = sc.next();
          departobj.head_of_depart = sc.nextInt();
          departobj.employee = new ArrayList<Employee>();
          int no_of_employees = sc.nextInt();
          for (int i=0; i < no_of_employees; i++) {
                departobj.employee.add(Employee.getEmployeeData(sc));
          }
          return departobj;
     } 
     public static /*Employee*/ void getLongEmployee(int index) {
          int long_id=0 ,count1 =0, id=0;//System.out.println(index);
          //System.out.println(Company.department.get(index).employee.size());
          for(int i=0; i < Company.department.get(index).employee.size(); i++) {
                 /*if ((Company.department.get(index).employee.get(i).emp_id) == long_id ) {
                        index1 = i;
                 }*/
                 int count=0;
                 //long_id = Company.department.get(index).employee.get(i).emp_id;
                 id = Company.department.get(0).employee.get(i).manager_id;System.out.println(id);
                 count++;
                 lable1: 
                 for(int j=0; j < Company.department.get(index).employee.size(); j++) {
                        if(Company.department.get(index).employee.get(j).emp_id == id) {
                                 id = Company.department.get(index).employee.get(j).manager_id; //System.out.println(id);
                                 count++;
                                 continue lable1;
                         }
                 } 
                 if (count1 <= count)
                 {
                     count1 = count;
                     long_id = Company.department.get(index).employee.get(i).emp_id;//System.out.println(long_id);
                 }
          }
          //System.out.println(long_id);
          //return Company.department.get(index).employee.get(index1);
     }
}
class Employee {
     int emp_id,manager_id,emp_age;
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



     
          

