package mode.find.frequency.com;
public class Mode {
    public static void main(final String[] args) {
        int length = args.length;
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        Mode m = new Mode();
        m.findMode(a , length);
    }
    public final void findMode(final int[] a, final int n) {
        int mode , curmode , frequency = 0 , curfreq = 0;
        mode = a[0];
        curmode = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] != mode) {
                mode = a[i];
                frequency = 1;
            } else if (a[i] == mode) {
                frequency++;
            }
            if (frequency > curfreq) {
                curfreq = frequency;
                curmode = mode;
            }
        }
        System.out.print("mode is " + curmode + "with frequency " + curfreq);
    }
}

