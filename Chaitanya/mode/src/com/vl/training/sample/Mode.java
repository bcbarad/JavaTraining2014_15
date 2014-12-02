package com.vl.training.sample;
public class Mode {
    public static void main(final String[] args) {
        int[] a = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        Mode m = new Mode();
        int[] result = new int[2];
        result = m.getMode(a);
        System.out.println("current mode"+result[0]+"Current Frequency"+result[1]);
    }
    final int[] getMode(final int[] a) {
        int currentmode = a[0], tempfrequency = 1;
        int currentfrequency = 1, i;
        int[] d = new int[ 2 ];
        for (i = 0; i < a.length - 1; i++) {
            if (a[ i ] == a[ i + 1 ]) {
                tempfrequency++;
            }
            else if (tempfrequency >= currentfrequency) {
                currentmode = a[ i ];
                currentfrequency = tempfrequency;
                tempfrequency = 1;
            }
            else {
                tempfrequency = 1;
            }
        }
        if (tempfrequency >= currentfrequency) {
            currentmode = a[ i ];
            currentfrequency = tempfrequency;
        }
        d[0] = currentmode;
        d[1] = currentfrequency;
        //System.out.println("highest frequency " + currentfrequency + "element is" + currentmode);
        return d;
    }
}
