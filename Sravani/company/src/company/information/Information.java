package company;
package company.information;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
public class Information {
    public static void main(final String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));
        Company comp = new Company();
        comp.compInfo(sc);
    }
}
