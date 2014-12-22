package com.vl.training.sample;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Department {
    String name,hodname;
    ArrayList<Employee> elist;
    int noofemployees;
    Department d;
    public Department getDepartment(Scanner sc) {
        d = new Department();
        d.elist = new ArrayList();
        d.name = sc.next();
        d.hodname = sc.next();
        d.noofemployees = sc.nextInt();
        for (int i = 0; i < d.noofemployees; i++) {
            Employee e = new Employee();
            Employee e1 = e.getEmployee(sc);
            d.elist.add(e1);
        }
        return d;
    }
}
