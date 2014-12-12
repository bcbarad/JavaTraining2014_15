package com.vl.training.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class ConcurrentRemovalEx {
    public static void main(final String arr[]) throws FileNotFoundException {
        if (arr.length !=2) {
            System.out.println("Required inputs not provided");
                return;
        } else {
            //Getting the file as input
            Scanner sc = new Scanner(new File(arr[0]));
            //age in years
            final int ageLimit = Integer.parseInt(arr[1]);
            List<Employee> employeeList = new ArrayList<Employee>();
            while (sc.hasNext()) {
                Employee e = new Employee(sc.next(), sc.nextInt());
                employeeList.add(e);
            }
            removeOverAge(employeeList, ageLimit);
            for (Employee e : employeeList) {
                System.out.println("Name: " + e.name + "    Age: "+ e.age);
            }
        }
    }

    public static void removeOverAge(List<Employee> empList, final int ageLimit){
        for (Iterator<Employee> iterator = empList.iterator(); iterator.hasNext();) {
            Employee e = iterator.next();
            if (e.age > ageLimit) {
                iterator.remove();
            }
        }
    }
}
class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
