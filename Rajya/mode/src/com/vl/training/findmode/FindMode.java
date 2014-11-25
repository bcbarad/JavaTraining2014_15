package com.vl.training.findmode;

public class FindMode {

    public final int getMode(final String []args) {
        int[] no = new int[args.length];
        int gmode = 0, gfreq = 0, cmode = 0, cfreq = 0;
        for (int i = 0; i < args.length; i++) {
            no[i] = Integer.parseInt(args[i]);
        }
        for (int i = 0; i < args.length; i++) {
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
        if (args.length == 0) {
            System.out.println("Please provide a no string");
        } else {
            int result = fm.getMode(args);
            System.out.println("Mode is:" + result);
        }
    }
}
