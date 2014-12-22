package com.vl.training.sample;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Employee {
    private String ename;
    private int eid;
    private double esal;
    private int mid;
    private Department deptName;
    private Date dob;
    public List<Employee> alldirectrepotiees = new ArrayList<Employee>();
    //SimpleDateFormat sdf = new SimpleDateFormat(yyyy/mm/dd);


    public Employee() {
    }
    public Employee(final String ename, final int eid, final double esal, final Department deptName, final Date dob) {
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

