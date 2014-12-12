package com.vl;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
public class Employee implements Comparable<Employee> {
    private String name;
    private  int age;
    public Employee(final String name, final int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int compareTo(Employee e) {
        Integer myAge = age;
        Integer eAge = e.age;
        return myAge.compareTo(eAge);
    }
   public static void removeOverAge(final List<Employee> list, final int years) {
       Iterator<Employee> itr = list.iterator();
       while (itr.hasNext()) {
           Employee e = itr.next();
           if (e.age > years) {
               itr.remove();
           }
       }
   }
   public static void display(final List<Employee> list) {
       for (Employee ee : list) {
           System.out.println("employee name is" +   ee.getName() + "age is"  +ee.getAge());
       }
   }
   public static void main(final String args[]) {
       List<Employee> list = new ArrayList<Employee>();
       list.add(new Employee("mouni", 21));
       list.add(new Employee("abc", 20));
       list.add(new Employee("xyz", 24));
       Collections.sort(list);
       System.out.println(list);
       display(list);
       Scanner sc = new Scanner(System.in);
       System.out.println("provide the years");
       int years = sc.nextInt();
       removeOverAge(list, years);
       display(list);
    }
}
