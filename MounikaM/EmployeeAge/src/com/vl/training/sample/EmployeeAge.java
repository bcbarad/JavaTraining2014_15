package com.vl.training.sample;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class EmployeeDetails {
    private String empName;
    private int empAge;

    public EmployeeDetails(String empName, int empAge) {
        this.empName = empName;
        this.empAge = empAge;

    }

    public int getEmpAge() {
        return empAge;
    }
    public String getEmpName() {
        return empName;
    }
}

public class EmployeeAge {
    public static void ageOverMethod(List list, int age) {

        Iterator<EmployeeDetails> itr = list.iterator();

        while (itr.hasNext()) {
            EmployeeDetails e = itr.next();
            if (e.getEmpAge() < age) {
                itr.remove();
            }
        }

    }
    public static void printEmpDetails(List<EmployeeDetails> list) {
        for (EmployeeDetails emp : list) {
            System.out.println("employee name is :" + emp.getEmpName() +  "  Age is " + emp.getEmpAge());
        }
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            List<EmployeeDetails> list = new ArrayList<EmployeeDetails>();

            list.add(new EmployeeDetails("ABC", 22));
            list.add(new EmployeeDetails("CDF", 26));
            list.add(new EmployeeDetails("LRU", 21));
            list.add(new EmployeeDetails("FIFO", 30));
            list.add(new EmployeeDetails("UDF", 19));
            list.add(new EmployeeDetails("XYZ", 35));

            System.out.println("\n Employee Details before callin OverAge method ");
            printEmpDetails(list);

            System.out.println("\n employee details whose age is above " + args[0]);
            int age = Integer.parseInt(args[0]);

            ageOverMethod(list, age);

            printEmpDetails(list);
        } else {
            System.out.println("\n enetr only one value that is age ");
        }
    }
}









