package com.vl.training.findmode;

public class FindMode {

    public final int getMode(final int []no) {
        int gmode = 0, gfreq = 0, cmode = 0, cfreq = 0;
        for (int i = 0; i < no.length; i++) {
            if (i == 0) {
                cmode = no[i];
                cfreq = 1;
            } else {
                if (no[i] == cmode) {
                    cfreq++;
                } else {
                    gmode = cmode;
                    gfreq = cfreq;
                    cmode = no[i];
                    cfreq = 1;
                }
            }
        }
        if (gfreq > cfreq) {
            return gmode;
        } else {
            return cmode;
        }
    }

    public static void main(final String []args) {
        FindMode fm = new FindMode();
        if (args.length == 4) {
            int[] no = new int[args.length];
            for (int i = 0; i < no.length; i++) {
                no[i] = Integer.parseInt(args[i]);
            }
            int result = fm.getMode(no);
            System.out.println("Mode is:" + result);

        } else {
            System.out.println("Please provide a no string");
        }
    }
}
