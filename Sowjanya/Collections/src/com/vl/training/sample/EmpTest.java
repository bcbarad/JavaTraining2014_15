package com.vl.training.sample;
class EmpTest {
    private String empname;
    private int empid;
    private int salary;
    EmpTest(final String name , final int id , final int sal) {
        this.empname = name;
        this.empid = id;
        this.salary = sal;
    }
    //@override
    public boolean equals(final Object o) {
        if (o instanceof EmpTest) {
            EmpTest emp = (EmpTest) o;
            if (this.empname.equals(emp.empname)) {
                return true;
            }
        }
        return false;
    }
    //@override
    public int hashCode() {
        return empid + salary + empname.length();
    }
}
