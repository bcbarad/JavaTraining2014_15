package company.code;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
public class CompanyInformation {
    public static void main(String[] args) throws FileNotFoundException {
        CompanyInformation cinfo = new CompanyInformation();
        if (args.length == 1) {
            Scanner sc = new Scanner(new File(args[0]));
            Company cc = Company.getCompanyDetails(sc);  // call the method to read the company details
            Company.longestChain(cc);        // call the method to find the longest chain in the company
            Company.getHighestAge(cc);       // call the method to find the highest age employee in company and each department
        } else {
            System.out.println(" Please provide the required input files ");
        }
    }
}

