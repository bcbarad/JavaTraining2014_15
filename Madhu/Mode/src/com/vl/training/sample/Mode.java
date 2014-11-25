package com.vl.training.sample;
public final class Mode {
    private Mode() {
    }
    static int mostRepeted(final int[] list) {
        int mode = list[0] , newmode = list[0] , tempfre = 0 , modefre = 1;
        int length = list.length;
        for (int i = 1; i < length; i++) {
            if (newmode == list[i]) {
                if (mode == newmode) {
                    modefre++;
                } else {
                    tempfre++;
                }
            } else {
                newmode = list[i];
                tempfre = 1;
            }
            if (tempfre >= modefre) {
                mode = newmode;
                modefre = tempfre;
                tempfre = 0;
            }
        }
        return mode;
    }
    public static void main(final String[] args) {
        int[] list = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            list[i] = Integer.parseInt(args[i]);
        }
        int mode = Mode.mostRepeted(list);
        System.out.println(" the mode  in the list is : " + mode);
    }
}
