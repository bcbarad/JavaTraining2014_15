package age.above.remove;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class AgeRemove {
    private String name;
    private int age;
    public AgeRemove(final String name ,final int age) {
        this.name = name;
        this.age = age;
    }
    public final String getName() {
        return this.name;
    }
    public final int getAge() {
        return this.age;
    }
    public static void delAge(final List<AgeRemove> allAge , final int ageLimit) {
        Iterator<AgeRemove> ar = allAge.iterator();
        while (ar.hasNext()) {
            AgeRemove ar1 = ar.next();
            if (ar1.age > ageLimit) {
                ar.remove();
            }
        }
    }
    public static void main(final String[] args) {
        List<AgeRemove> ageList = new ArrayList<AgeRemove>();
        ageList.add(new AgeRemove("sravani" , 22));
        ageList.add(new AgeRemove("mouni" , 55));
        ageList.add(new AgeRemove("reddy" , 19));
        ageList.add(new AgeRemove("madhu" , 32));
        ageList.add(new AgeRemove("souji" , 30));
        ageList.add(new AgeRemove("raji" , 30));
        ageList.add(new AgeRemove("bikash", 34));
        ageList.add(new AgeRemove("kavitha" , 25));
        ageList.add(new AgeRemove("srinivas" , 69));
        ageList.add(new AgeRemove("chaithanya", 35));
        System.out.println("list before removing the age");
        for (AgeRemove ar : ageList) {
            System.out.println(ar.getName() + "," + ar.getAge());
        }
        Scanner sc = new Scanner(System.in);
        int ageLimit;
        System.out.println("enter the limit of the age");
        ageLimit = sc.nextInt();
        AgeRemove.delAge(ageList , ageLimit);
        System.out.println("list after removing the age");
        for (AgeRemove ar : ageList) {
            System.out.println(ar.getName() + "," + ar.getAge());
        }
    }
}

