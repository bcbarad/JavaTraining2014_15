package com.vl.training.sample;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public final class EmpAges {
    private EmpAges() {
    }
    public static void main(final String[] args) {
        //creating a list to store employee names and ages
        List<Employee> empage = new ArrayList<Employee>();
        //adding details of the employee
        empage.add(new Employee("ion" , 41));
        empage.add(new Employee("aarish" , 52));
        empage.add(new Employee("sai" , 46));
        empage.add(new Employee("chinni" , 54));
        System.out.println("Before removal");
        Employee.display(empage);
        Employee.remove(empage , 50);
        System.out.println("After removal");
        Employee.display(empage);
    }
}
class Employee {
    private Employee() {
    }
    private String name;
    private int age;
    Employee(final String ename, final int eage) {
        this.name = ename;
        this.age = eage;
    }
    public static void display(final List<Employee> empage) {
        for (Employee ea : empage) {
            System.out.println(ea.name + ":" + ea.age);
        }
    }
    public static void remove(final List<Employee> empage , final int age) {
        Iterator<Employee> it = empage.iterator();
        while (it.hasNext()) {
            Employee ea = it.next();
            if (ea.age >= age) {
                it.remove();
            }
        }
    }
}
