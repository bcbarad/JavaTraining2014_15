package company.code;
import java.util.*;
import java.io.*;
public class Company {
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
    public static Employee  getLongChainId(String department_name , Company comobj) {
        int long_id = 0 , depart_index = 0;
        Employee long_emp;
        for (int i = 0; i < comobj.alldepartments.size(); i++) {
            if (department_name.equals(comobj.alldepartments.get(i).department_name)) {
                depart_index = i;
            }
        }
        long_emp = Company.getLongEmployee(depart_index , comobj);
        return long_emp;
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
