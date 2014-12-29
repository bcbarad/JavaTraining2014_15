package bank.code;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Map;
import java.io.FileNotFoundException;
class BankTransactionProcess {
    Hashtable<Integer , Account> bankdata = new Hashtable<Integer , Account>();
    public void transactionProcess(Scanner sc) throws FileNotFoundException {
        while (sc.hasNext()) {
            Integer customid = sc.nextInt();
            String transtype = sc.next();
            double amount = Double.parseDouble(sc.next());
            synchronized(bankdata) {
            Account totalamount = (Account) bankdata.get(customid);
            if (totalamount == null) {
                    if (transtype.equals("withdraw")) {  					//check that is the initial transaction be withdraw, id yes then amount should be negative
                        amount = 0 - amount;
                        totalamount = new Account(customid, amount);
                    }else if (transtype.equals("deposite")){
                        totalamount = new Account(customid, amount);
                    }
                    bankdata.put(customid , totalamount);
            } else  {
                    if (transtype.equals("deposite")) {                 // this check and adds the amount to accountid
                        totalamount.deposit(amount);
                    } else if (transtype.equals("withdraw")) {                // this check and subtracts the amount from account id
                        totalamount.withdraw(amount);
                    }
                    bankdata.put(customid , totalamount);	        
            }
          } 
        }
    }
    public void displayFinalAccountSummary() {       // this method displays the final amount of all accounts after completion of the all files
        Set<Map.Entry<Integer , Account>> set= bankdata.entrySet();
        System.out.println("\n Account-id   Amount");
        for(Map.Entry<Integer , Account> bankm:set){
            Account acc = (Account) bankm.getValue();
            System.out.println(acc.getId()+"           "+acc.getAmount());
        }
    }
}
