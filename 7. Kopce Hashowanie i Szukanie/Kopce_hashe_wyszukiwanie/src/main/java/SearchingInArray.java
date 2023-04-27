import java.util.Arrays;
import java.util.Random;

public class SearchingInArray {

    private int[] array;

    public SearchingInArray(int[] array) {
        this.array = array;
    }

    public SearchingInArray(int randomArraySize) {
        setRandomArray(randomArraySize);
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setRandomArray(int randomArraySize) {
        Random random = new Random();
        int[] randomArray = new int[randomArraySize];
        for (int i = 0; i < randomArraySize; i++) {
            randomArray[i] = random.nextInt(100);
        }
        this.array = randomArray;
    }

    public int linearSearch(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return -1;
    }

    public void sortArray() {
        // Cast array of int to array of Integer
        Integer[] array = Arrays.stream(this.array).boxed().toArray(Integer[]::new);

        // Sort
        HeapPriorityQueue.heapSort(array);

        // Cast array of Integer to array of int
        this.array = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
    }

    @Override
    public String toString() {
        return "SearchingInArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

}
