package com.vl.sf.core;
public class Emp {
    private String name=null;
    @Override
    public String toString() {
        return name+": "+age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private int age=0;
    public Emp() {}
    public Emp(String name, int age){
        this.name=name;
        this.age=age;
    }
}

