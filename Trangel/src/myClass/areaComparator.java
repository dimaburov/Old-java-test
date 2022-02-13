package myClass;

import java.util.Comparator;

public class areaComparator implements Comparator<Triangle> {
    @Override
    public  int compare(Triangle o1 ,Triangle o2){
        return (int )(o1.areas()-o2.areas());
    }
}
