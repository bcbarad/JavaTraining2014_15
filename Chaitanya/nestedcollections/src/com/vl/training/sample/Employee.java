package com.vl.training.sample;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
class Employee {
    int eid,salary,managerid;
    String name;
    Employee e;
    Date dob;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
    public Employee getEmployee(Scanner sc) {
        e = new Employee();
        e.eid = sc.nextInt();
        e.salary = sc.nextInt();
        e.managerid = sc.nextInt();
        e.name = sc.next();
        try {
            e.dob = sdf.parse(sc.next());
        } catch (Exception pe) {
            System.out.print(pe);
        }
        return e;
    }
}
