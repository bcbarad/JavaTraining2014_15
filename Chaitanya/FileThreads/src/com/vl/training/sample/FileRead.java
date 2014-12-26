package com.vl.training.sample;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
class FileRead {
    public void accountDetails(final File f, final Map m) {
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] total = str.split(" ");
                String curid = total[0];
                String type = total[1];
                int amount = (Integer.parseInt(total[2]));
                //System.out.println("current id"+curid);
                boolean check = false;
                synchronized (curid) {
                    if (!m.containsKey(curid) && type.equals("D")) {
                //System.out.println("log" + Thread.currentThread().getId());
                        m.put(curid, amount);
                    } else if (m.containsKey(curid)) {
                        int temp = (Integer) m.get(curid);
                        if (type.equals("D")) {
                            amount = temp + amount;
                            //System.out.println("deposit valuecurrentthread"+
                            // Thread.currentThread().getId()
                            //+"id"+curid+"putting"+m.put(curid,amount));
                            check = true;
                        } else if (type.equals("W")) {
                             //System.out.println("withdraw valuecurrentthread"+
                             //Thread.currentThread().getId()
                             //+"id"+curid+"putting"+m.put(curid,amount));
                            amount = temp - amount;
                            check = true;
                        }
                    }
                    if (check) {
                        m.put(curid, amount);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    final void display(final Map m) {
        Set<String> keys = m.keySet();
        for (String i : keys) {
            System.out.println("id of customer " + i
                + " has amount " + m.get(i));
        }
    }
}
