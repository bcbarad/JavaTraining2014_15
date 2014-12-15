package com.vl.sf.core;

import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

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
        ListIterator listr=list.listIterator();
        while(listr.hasNext()){
			Object o = listr.next();
			if (o instanceof Emp) {
				Emp e = (Emp) o;
				if (e.getAge() > age) {
					listr.remove();
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

