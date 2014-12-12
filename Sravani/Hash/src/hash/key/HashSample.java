package hash.key;
import java.util.*;
class Key {
    private int id;
    private String firstname;
    private String lastname;
    public Key(int id , String firstname , String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public String getFirstName() {
        return firstname;
    }
    public String getLastName() {
        return lastname;
    }
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Key guest = (Key) obj;
        return id == guest.id && (firstname == guest.firstname || (firstname != null && firstname.equals(guest.getFirstName()))  && (lastname == guest.lastname || (lastname != null && lastname.equals(guest.getLastName()))));
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + id;
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + id;
        return result;
    }
    public static void hmap(Map m){
        Key k1 = new Key(40 , "guddety" , "Sravani");
        String result = (String) m.get(k1);
        System.out.println(result);
    }
}
public class HashSample {
    public static void main(String[] args) {
        Map<Key , String> m = new HashMap<Key , String >();
        Key k1 = new Key(40 , "guddety" , "Sravani");
        m.put(k1 , "success");
        k1.hmap(m);
    }
}
