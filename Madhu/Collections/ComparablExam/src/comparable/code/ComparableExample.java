package comparable.code;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
public final  class ComparableExample {
    private ComparableExample() {
    }
    public static void main(final String[] args) {
        List arrlist = new ArrayList();
        arrlist.add(new Student(1 , "Balu" , 22));
        arrlist.add(new Student(2 , "raju" , 21));
        arrlist.add(new Student(3 , "babu" , 23));
        ComparableExample.display(arrlist);
    }
    public static void display(final List arrlist) {
        Iterator itr = arrlist.iterator();
        System.out.println("The list before sorting");
        while (itr.hasNext()) {
            Student st = (Student) itr.next();
            System.out.println(st.sid + " " + st.sname + " " + st.sage);
        }
        Collections.sort(arrlist);
        System.out.println("The list atfer sorting");
        Iterator itr1 = arrlist.iterator();
        while (itr1.hasNext()) {
            Student st = (Student) itr1.next();
            System.out.println(st.sid + " " + st.sname + " " + st.sage);
        }
    }
}
class Student implements Comparable {
    int sid , sage;
    String sname;
    Student(final int sid , final String sname , final int sage) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
    }
    public int compareTo(final Object obj) {
        Student st = (Student) obj;
        if (this.sage == st.sage) {
            return 0;
        } else if (this.sage > st.sage) {
            return 1;
        } else {
            return -1;
        }
    }
}
