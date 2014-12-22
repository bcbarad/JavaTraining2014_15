package com.vl.training.sample;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


public class Employee {
    private String ename;
    private int eid;
    private double esal;
    private int mid;
    public Employee manager;
    List<Employee> alldirectrepotiees = new ArrayList<Employee>();


    public Employee() { }
    public Employee(String ename, int eid, double esal) {
        this.ename = ename;
        this.eid = eid;
        this.esal = esal;
    }

    public int getEmpid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }
    public Double getEsal() {
        return esal;
    }

}

