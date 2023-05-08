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
        SearchingInArray searchingInArray = new SearchingInArray(20);
        searchingInArray.sortArray();
        System.out.println(searchingInArray);
        System.out.println(searchingInArray.binarySearch(42));
    }

    private static void demo3() {
        HashTable table = new HashTable(8, 0.75);

        // Test put() method
        table.put(1, "apple");
        table.put(2, "banana");
        table.put(3, "cherry");
        table.put(4, "date");
        table.put(5, "elderberry");
        table.put(6, "fig");
        table.put(7, "grape");
        table.put(8, "honeydew");
        table.put(9, "orange");
        table.put(10, "pineapple");

        // Test get() method
        System.out.println(table.get(1)); // apple
        System.out.println(table.get(5)); // elderberry
        System.out.println(table.get(10)); // pineapple

        // Test containsKey() method
        System.out.println(table.containsKey(3)); // true
        System.out.println(table.containsKey(6)); // true
        System.out.println(table.containsKey(11)); // false

        // Test size() method
        System.out.println(table.size()); // 10

        // Test isEmpty() method
        System.out.println(table.isEmpty()); // false

        // Test resize() method
        table.resize(16);

        // Test dump() method
        table.dump();
    }

    public static void main(String[] args) {

        // Zad 1
//        demo1();

        // Zad 2
        demo2();

        // Zad 3
//        demo3();

    }

}
