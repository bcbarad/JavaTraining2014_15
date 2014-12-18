package company.code;
import java.util.*;
import java.io.*;
public class CompanyInformation {
    Company companydata = new Company();
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("please provide the required arguments ");
        } else {
            Scanner sc = new Scanner(new File(args[0]));
            CompanyInformation cominfo = new CompanyInformation();
            cominfo.companydata = Company.getCompanyData(sc);
            String department_name =  sc.next();
            Employee long_emp = Company.getLongChainId(department_name , cominfo.companydata);     
            System.out.println("the longet chain employee details: name--" + long_emp.emp_name +  "--employee id-- " + long_emp.emp_id + "--salary-- " + long_emp.emp_salary);
        }
    }
    
}



