package sort.code;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public final class SimpleCollecSort {
    private SimpleCollecSort() {
    }
    public static void main(final String[] args) {
        String[] init = {"One" ,  "Two" , "Three" , "Four" , "Five" , "Six" };
        List list = new ArrayList(Arrays.asList(init));
        System.out.println("List value before: " + list);
        Collections.sort(list);
        System.out.println("List value after sort: " + list);
    }
}
