package com.vl.sf.core;
import java.util.Comparator;
public class ExampleComparator implements Comparator {
    @Override
    public int compare(Object obj1, Object obj2) throws ClassCastException{
        if(obj1 instanceof Example && obj2 instanceof Example){
            Example e1=(Example)obj1;
            Example e2=(Example)obj2;
            return e2.compareTo(e1);
        }else {
            throw new ClassCastException();
        }
    }
}

