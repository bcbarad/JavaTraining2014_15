package check.find.prime.com;
import java.lang.Math.;
public class Prime1 {
    public static void main(final String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        Prime1 p = new Prime1();
        boolean res = p.findPrime(a, b);
        if (res) {
            System.out.println("conditions applies successfully");
        } else {
            System.out.println("conditions failed for given numbers.... please enter suitable number");
        }
    }
    public final boolean findPrime(final int a, final int b) {
        if ((a - b == 2) || (b - a == 2)) {
            Prime1 p = new Prime1();
            if (p.prime(a)) {
                if (p.prime(b)) {
                    return true;
                }
            }
        }
        return false;
    }
    public final boolean prime(final int a) {
        for (int i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}

