package myClass;

import java.util.Comparator;

public class firstNameComparator implements Comparator<Book> {
    @Override
    public  int compare(Book o1 ,Book o2){
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
