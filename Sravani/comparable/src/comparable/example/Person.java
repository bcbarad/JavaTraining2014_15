package comparable.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Person implements Comparable<Person> {
    private String name;
    private String lastName;
    public Person(final String name , final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    public final String getName() {
        return name;
    }
    public final String getLastName() {
        return lastName;
    }
    public final int compareTo(final Person p) {
        return (this.name).compareTo(p.getName());
    }
    public static void main(final String[] args) {
        List<Person> myList = new ArrayList<Person>();
        myList.add(new Person("Sravani" , "Jntu"));
        myList.add(new Person("Aishwarya" , "Lakdikapool"));
        myList.add(new Person("Jothi" , "Kurnool"));
        Collections.sort(myList);
        for (Person person : myList) {
            System.out.println("My name is " + person.getName());
        }
    }
}
