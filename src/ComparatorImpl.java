import java.util.Comparator;

public class ComparatorImpl implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if(o1.getName().compareTo(o2.getName()) > 0){
            return 1;
        } else {
            return -1;
        }
    }
}
