package com.vl.training.sample;
import java.util.*;

public class Employee {
    String name;
    int age;
    public Employee(final String name, final int age) {
        this.name = name;
        this.age = age;
    }
    public static void removeOverAge(final List<Employee> allEmployees, final int age) {
        Iterator<Employee> itr = allEmployees.iterator(); 
        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.age >= age) {
                itr.remove();
            }
        }
    }
    public static void displayEmp(final List<Employee> allEmployees) {
        for (Employee e: allEmployees) {
            System.out.println(e.name + " " + e.age);
        }
    }
    public static void main(final String []agrs) {
        List<Employee> allEmployees = new ArrayList<Employee>();
        Employee e1 = new Employee("John", 45);
        Employee e2 = new Employee("Ram", 67);
        Employee e3 = new Employee("Latha", 38);
        Employee e4 = new Employee("Fedrick", 59);
        allEmployees.add(e1);
        allEmployees.add(e2);
        allEmployees.add(e3);
        allEmployees.add(e4);
        displayEmp(allEmployees);
        removeOverAge(allEmployees, 55);
        System.out.println("Emplyees who are below 56 :");
        displayEmp(allEmployees);
    }
}

