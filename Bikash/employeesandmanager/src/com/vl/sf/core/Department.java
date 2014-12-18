package com.vl.sf.core;
public class Department{
	private String name;
	private Employee head;
	protected Department(String name){
		this.name = name;	
	}
	protected void setDeptManager(Employee head){
		this.head = head;
	}
	public Employee getDeptManager(){
		return head;	
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", head=" + head + "]";
	}
	
}
