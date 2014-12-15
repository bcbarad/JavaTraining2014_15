package comparator.person.age;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class PersonComparator implements Comparator<PersonComparator> {
    private String firstName;
    private int age;
    PersonComparator() {
    }
    public PersonComparator(final String firstName , final int age) {
        this.firstName = firstName;
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public int getAge() {
        return age;
    }
    public int compare(final PersonComparator pc1 , final PersonComparator pc2) {
        return pc1.age - pc2.age;
    }
}
public final class Test2 {
    private Test2() {
    }
    public static void main(final String[] arg) {
        List<PersonComparator> myList = new ArrayList<PersonComparator>();
        myList.add(new PersonComparator("Sravani" , 22));
        myList.add(new PersonComparator("Aishwarya" , 19));
        myList.add(new PersonComparator("Jothi" , 24));
        Collections.sort(myList , new PersonComparator());
        for (PersonComparator person : myList) {
            System.out.println("My name is " + person.getFirstName() + " " + person.getAge());
        }
    }
}

