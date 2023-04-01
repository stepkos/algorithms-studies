import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator<T> implements Comparator<T> {
    private final List<Comparator<T>> comparators = new ArrayList<>();

    public void addComparator(Comparator<T> comparator) {
        comparators.add(comparator);
    }

    public int compare(T left, T right) {
        int result = 0;
        for (Comparator<T> comparator: comparators) {
            result = comparator.compare(left, right);
            if (result != 0) break;
        }
        return result;
    }

}
