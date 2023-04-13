import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort<T> {

    private final Comparator<T> comparator;

    public QuickSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public List<T> quickSort(List<T> list) {
        quickSort(list, 0, list.size() - 1);
        return list;
    }

    private void quickSort(List<T> list, int startIdx, int endIdx) {
        if (endIdx - startIdx <= 1) return;
        int partition = partition(list, startIdx, endIdx);
        quickSort(list, startIdx, partition);
        quickSort(list, partition + 1, endIdx);
    }

    private int partition(List<T> list, int startIdx, int endIdx) {
        int pivotIdx = startIdx + new Random().nextInt(endIdx - startIdx + 1);
        T pivot = list.get(pivotIdx);
        swap(list, pivotIdx, endIdx);
        int left = startIdx;
        int right = endIdx - 1;
        while (left <= right) {
            while (left <= right && comparator.compare(list.get(left), pivot) <= 0) left++;
            while (left <= right && comparator.compare(list.get(right), pivot) > 0) right--;
            if (left < right) swap(list, left, right);
        }
        swap(list, left, endIdx);
        return left;
    }


    private void swap(List<T> list, int left, int right) {
        if (left == right) return;
        T tmp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, tmp);
    }

    public static void demo() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add((int) (Math.random() * 100));
        }
        QuickSort<Integer> quickSort = new QuickSort<>(Integer::compareTo);
        List<Integer> sortedList = quickSort.quickSort(list);
        System.out.println(sortedList);
    }

    public static void main(String[] args) {
        demo();
    }

}
