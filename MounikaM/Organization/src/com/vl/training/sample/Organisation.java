package com.vl.training.sample;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Organisation {
    public static void main(String[] args) {
        if (args.length >= 2) {
            try {
                Employee emp;
                Employee e;
                Scanner sc = new Scanner(new File(args[0]));
                Scanner sc1 = new Scanner(new File(args[1]));
                Scanner sc2 = new Scanner(new File(args[2]));
                Company c = new Company();
                c.readCompanyDetails(sc, sc1,  sc2);
                c.printAllDirectRepotiees(c.allEmployees);
                emp = c.getMaxAge(c.allEmployees);
                System.out.println(emp.getEname() + " has maximum age");
                e = c.getLongestchainHod(c.allEmployees);
                System.out.println(e.getEname() + " has longest chain among all other HOD's");
            } catch (FileNotFoundException nfe) {
                System.err.println(nfe);
            }
        } else {
            System.out.println("\n please enter  2 file names as argument");
        }
    }
}
