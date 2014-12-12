package com.vl.sf.core;

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ListDemo {

	public static void main(String[] args) {
		List list = new ArrayList();
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter "+args[1]+" employees name and age:");
		addElements(list, scanner,Integer.parseInt(args[1]));
		System.out.println(list);
		removeOverAge(list, Integer.parseInt(args[0]));
		System.out.println(list);
	}

	private static void removeOverAge(List list, int age) {
		for (int index = 0; index < list.size(); index++) {
			Object o = list.get(index);
			if (o instanceof Emp) {
				Emp e = (Emp) o;
				if (e.getAge() > age) {
					list.remove(e);
					index--;
				}
			}
		}
	}

	private static void addElements(List list, Scanner scanner,int noOfEmployees) {
		for (int i = 0; i < noOfEmployees; i++) {
			list.add(new Emp(scanner.next(), scanner.nextInt()));
		}

	}

}

