import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static void demo1() {
        List<Integer> list = new ArrayList<>(List.of(5, 7, 2, 1, 3, 8, 4));
        HeapPriorityQueue<Integer> heap = new HeapPriorityQueue<>((a, b) -> a.compareTo(b), list);
        heap.changePriority(3, 10);
        heap.remove(2);
        System.out.println("Kolejka: " + heap);

        // Usuwanie elementów z kolejki i wyświetlanie ich
        while (!heap.isEmpty()) {
            System.out.println("Najwyższy priorytet: " + heap.dequeue());
        }

        // Sortowanie elementów tablicy przy użyciu kopca
        Integer[] arr = {5, 1, 3, 4, 2};
        HeapPriorityQueue.heapSort(arr);

        // Wyświetlanie posortowanej tablicy
        System.out.print("Posortowana tablica: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void demo2() {
        SearchingInArray searchingInArray = new SearchingInArray(10);
        searchingInArray.sortArray();
        System.out.println(searchingInArray);
    }

    public static void main(String[] args) {

        // Zad 1
        // zilustruj dzialanie
//        demo1();

        // Zad 2
        demo2();

    }

}
