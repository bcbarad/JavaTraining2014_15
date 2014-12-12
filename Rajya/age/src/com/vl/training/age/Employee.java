package com.vl.training.age;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public final class Employee {

    private String eName;
    private int age;

    public Employee(final String name, final int years) {
        this.eName = name;
        this.age = years;
    }

    static void removeOverAge(final List<Employee> allEmployees, final int years) {
        Iterator<Employee> itr = allEmployees.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.age > years) {
                itr.remove();
            }
        }
    }

    static void listAfterRemove(final List<Employee> allEmployees) {
        for (Employee e : allEmployees) {
            System.out.println(e.eName + ", " + e.age);
        }
    }

    public static void main(final String []args) {
        if (args.length == 1) {
            int years = Integer.parseInt(args[0]);
            List<Employee> allEmployees = new ArrayList<Employee>();
            Employee e1 = new Employee("Amala", 24);
            Employee e2 = new Employee("Ashok", 25);
            Employee e3 = new Employee("Arun", 22);
            Employee e4 = new Employee("Kamala", 26);
            allEmployees.add(e1);
            allEmployees.add(e2);
            allEmployees.add(e3);
            allEmployees.add(e4);
            removeOverAge(allEmployees, years);
            listAfterRemove(allEmployees);
        } else {
            System.out.println("Please provide arguments");
        }
    }

}
