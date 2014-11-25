package fmax.smax.com;
public class Secondmax {
    public static void main(final String[] args) {
        int length = args.length;
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(args[i]);
        }
        Secondmax sm = new Secondmax();
        int secmax = sm.maximum(a, length);
        System.out.println("Second max:" + secmax);
    }
    protected final int maximum(final int[] a , final int n) {
        int max1, max2 = 0;
        max1 = a[0];
        for (int i = 1; i < n; i++) {
            if (max1 < a[i]) {
                max2 = max1;
                max1 = a[i];
            }
        }
        return max2;
    }
}
