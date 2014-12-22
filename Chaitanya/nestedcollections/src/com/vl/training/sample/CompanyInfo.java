package com.vl.training.sample;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
public class CompanyInfo {
    public static void main(String[] args) throws FileNotFoundException {
        CompanyInfo cinfo = new CompanyInfo();
        Scanner sc = new Scanner(new File(args[0]));
        Company c = new Company();
        Company cc = c.companyDetails(sc);
        c.longestChain(cc);
        c.getHighestAge(cc);
    }
}

