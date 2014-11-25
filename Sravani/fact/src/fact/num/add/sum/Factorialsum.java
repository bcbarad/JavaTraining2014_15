package fact.num.add.sum;
public final class Factorialsum {
    public static void main(final String[] args) {
        int n = Integer.parseInt(args[0]);
        Factorialsum fs = new Factorialsum();
        int seriessum = fs.check(n);
        System.out.println("sum:" + seriessum);
    }
    private Factorialsum() {
    }
    public int check(final int n) {
        int sum = 1 , j = 0 , mul = 1;
        for (int i = 1; i < n; i++) {
            j = j + 2;
            mul = mul * j * (j - 1);
            sum = sum + mul;
        }
        return sum;
    }
}
