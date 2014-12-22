package com.vl.training.sample;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Date;


public class Employee {
    private String ename;
    private int eid;
    private double esal;
    private int mid;
    public Department deptName;
    public Employee manager;
    public Date dob;
    List<Employee> alldirectrepotiees = new ArrayList<Employee>();


    public Employee() { }
    public Employee(String ename, int eid, double esal, Department deptName, Date dob) {
        this.ename = ename;
        this.eid = eid;
        this.esal = esal;
        this.deptName = deptName;
        this.dob = dob;
    }

    public int getEmpid() {
        return eid;
    }
    public Date getDob() {
        return dob;
    }

    public String getEname() {
        return ename;
    }
    public Double getEsal() {
        return esal;
    }
    public Department getEdeptName() {
        return deptName;
    }

}

