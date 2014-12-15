package comparator.code;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
public final  class ComparatorExample {
    private ComparatorExample() {
    }
    public static void main(final String[] args) {
        List arrlist = new ArrayList();
        arrlist.add(new Student(1 , "balu" , 22));
        arrlist.add(new Student(2 , "raju" , 21));
        arrlist.add(new Student(3 , "babu" , 23));
        ComparatorExample.display(arrlist);
    }
    public static void display(final List arrlist) {
        Iterator itr = arrlist.iterator();
        Collections.sort(arrlist, new AgeComparator());
        System.out.println("The list  sorting base on age");
        while (itr.hasNext()) {
            Student st = (Student) itr.next();
            System.out.println(st.sid + " " + st.sname + " " + st.sage);
        }
        Collections.sort(arrlist , new NameComparator());
        System.out.println("The list sorting based on name");
        Iterator itr1 = arrlist.iterator();
        while (itr1.hasNext()) {
            Student st = (Student) itr1.next();
            System.out.println(st.sid + " " + st.sname + " " + st.sage);
        }
    }
}
class Student  {
    int sid , sage;
    String sname;
    Student(final int sid , final  String sname , final int sage) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
    }
}
class AgeComparator implements Comparator {
    public int compare(final Object obj1 , final  Object obj2) {
        Student st1 = (Student) obj1;
        Student st2 = (Student) obj2;
        if (st1.sage == st2.sage) {
            return 0;
        } else if (st1.sage > st2.sage) {
            return 1;
        } else {
            return -1;
        }
    }
}
class NameComparator implements Comparator {
    public int compare(final Object obj1 , final Object obj2) {
        Student st1 = (Student) obj1;
        Student st2 = (Student) obj2;
        return st1.sname.compareTo(st2.sname);
    }
}
