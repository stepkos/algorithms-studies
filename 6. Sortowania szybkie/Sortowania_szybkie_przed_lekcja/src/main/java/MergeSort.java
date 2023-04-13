import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeSort<T> {

    private final Comparator<T> comparator;

    public MergeSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public List<T> mergeSort (List<T> list) {
        return mergeSort(list, 0, list.size() - 1);
    }

    @SuppressWarnings("unchecked")
    private List<T> mergeSort(List<T> list, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            List<T> result = (List<T>) new ArrayList<Object>();
            result.add(list.get(startIdx));
            return result;
        }

        int splitIdx = startIdx + (endIdx - startIdx) / 2;
        return merge(
                mergeSort(list, startIdx, splitIdx),
                mergeSort(list, splitIdx + 1, endIdx)
        );
    }

    @SuppressWarnings("unchecked")
    private List<T> merge(List<T> left, List<T> right) {
        List<T> result = (List<T>) new ArrayList<Object>();
        Iterator<T> leftIter = left.iterator();
        Iterator<T> rightIter = right.iterator();
        T leftElem = null, rightElem = null;
        boolean leftCont = leftIter.hasNext();
        boolean rightCont = rightIter.hasNext();
        if(leftCont) leftElem = leftIter.next();
        if(rightCont) rightElem = rightIter.next();

        while (leftCont && rightCont) {
            if (comparator.compare(leftElem, rightElem) <= 0) {
                result.add(leftElem);
                leftCont = leftIter.hasNext();
                if (leftCont) leftElem = leftIter.next();
                else result.add(rightElem);
            }
            else {
                result.add(rightElem);
                rightCont = rightIter.hasNext();
                if (rightCont) rightElem = rightIter.next();
                else result.add(leftElem);
            }
        }

        while (leftIter.hasNext()) result.add(leftIter.next());
        while (rightIter.hasNext()) result.add(rightIter.next());

        return result;
    }

    public static void demo() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add((int) (Math.random() * 100));
        }
        MergeSort<Integer> mergeSort = new MergeSort<>(Integer::compareTo);
        List<Integer> sortedList = mergeSort.mergeSort(list);
        System.out.println(sortedList);
    }

    public static void main(String[] args) {
        demo();
    }

}
