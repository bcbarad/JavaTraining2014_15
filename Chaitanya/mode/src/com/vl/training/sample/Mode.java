package com.vl.training.sample;
public class Mode {
    public static void main(final String[] args) {
        int[] a = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        Mode m = new Mode();
        m.setMode(a);
    }
    final void setMode(final int[] a) {
        int currentmode = a[0], tempfrequency = 1;
        int currentfrequency = 1, i;
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
        System.out.println("highest frequency " + currentfrequency + "element is" + currentmode);
    }
}
