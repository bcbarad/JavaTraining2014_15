package com.vl.training.organisation;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
public class Organisation {
    public static void main(String[] arr) throws IOException {
        if(arr.length != 1){
            System.out.println("Input parameter should be exactly one");
            return;
        }
        else{
            Scanner sc = new Scanner(new File(arr[0]));
            createStructure(sc);
        }
    }
    static void createStructure(Scanner sc) {
        
        Company c = Company.readCompany(sc);
        c.printHierarchy(c.ceo);
    }
}

class Company {
    static Employee ceo;
    private String name;
    private String uri;
    //Set<Department> department = new HashSet<Department>();

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setUri(String uri) {
        this.uri = uri;
    }

    String getUri() {
        return uri;
    }
    void printHierarchy(Employee ceo) {
         //Employee current = ceo;
         for ( Employee e : ceo.directReportees){           
             System.out.println("Employee : " + e.getId() + "Name : " + e.getName() + " Manager ID : " + e.manager.getId());
             if (!e.directReportees.isEmpty()) {
                printHierarchy(e);
             }
        }
 } 	
    static Company readCompany(Scanner sc) {
       Company com = new Company();
       com.name = sc.next();
       com.uri = sc.next();
       ceo = Employee.readEmployee(sc);
       while(sc.hasNext()) { 
         Employee emp = Employee.readEmployee(sc);
         String mgrId = sc.next();
         Employee mgr = com.getEmployee(mgrId,ceo);
         mgr.directReportees.add(emp);
         emp.manager = mgr;        
       }
       
       return com;
    }
    
    Employee getEmployee(final String empid, Employee current) {
         if (current.getId() == empid) 
              return current;
         else {
               Iterator<Employee> itr = current.directReportees.iterator();
               while(itr.hasNext()){
                  Employee e =itr.next();
                  if (e.getId() == empid) {
                        return e;
                  } else {
                        current = getEmployee(empid,e);
                        if (current.getId() == empid)
                                return current;
                  }
               }
         }
         return current;
    }
}

class Employee {
    private String name;
    String id;
    private int salary;
    private Date dob;
    Employee manager;
    ArrayList<Employee> directReportees = new ArrayList<Employee>();
    
    static Employee readEmployee(Scanner sc) {
     Employee emp = new Employee();
     emp.setId(sc.next());
     emp.setName(sc.next());     
     emp.setSalary(sc.nextInt());
     emp.setDOB(sc.next());
     return emp;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setId(String id) {
        this.id = id;
    }

    String getId() {
        return id;
    }

    void setSalary(int salary) {
        this.salary = salary;
    }

    int getSalary() {
        return salary;
    }

    void setDOB(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dob = (Date) formatter.parse(dateInString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Date getDOB() {
        return dob;
    }
}
