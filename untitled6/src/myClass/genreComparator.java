package myClass;

import java.util.Comparator;

public class genreComparator implements Comparator<Book> {
    @Override
    public  int compare(Book o1 ,Book o2){
        return o1.getGenre().compareTo(o2.getGenre());
    }
}
