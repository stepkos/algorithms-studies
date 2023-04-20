import java.util.Random;

public class AlgorithmsComparison {

    public static int mergeSortCompCounter = 0;
    public static int mergeSortRewriteCounter = 0;
    public static int quickSortCompCounter = 0;
    public static int quickSortRewriteCounter = 0;

    public static int[] selectionSort(int[] array) {
        System.out.println("\nSelection sort");

        int compCounter = 0;
        int rewriteCounter = 0;

        int[] result = array.clone();
        for (int i = 0; i < result.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < result.length; j++) {
                compCounter++;
                if (result[j] < result[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = result[i];
            result[i] = result[minIdx];
            result[minIdx] = tmp;
            rewriteCounter += 3;
        }

        System.out.println("Comp counter: " + compCounter);
        System.out.println("Rewrite Counter: " + rewriteCounter);

        return result;
    }

    public static int[] insertionSort(int[] array) {
        System.out.println("\nInsertion sort");

        int compCounter = 0;
        int rewriteCounter = 0;
        int[] result = array.clone();

        for (int i = 1; i < result.length; i++) {
            int j = i - 1;
            int key = result[i];
            while (j >= 0 && result[j] > key) {
                compCounter++;
                result[j + 1] = result[j];
                rewriteCounter++;
                j--;
            }
            result[j + 1] = key;
            rewriteCounter++;
        }

        System.out.println("Comp counter: " + compCounter);
        System.out.println("Rewrite Counter: " + rewriteCounter);

        return result;
    }

    public static int[] mergeSort(int[] array) {
        System.out.println("\nMerge sort");
        mergeSortCompCounter = 0;
        mergeSortRewriteCounter = 0;
        int[] result = mergeSort(array.clone(), 0, array.length - 1);
        System.out.println("Comp counter: " + mergeSortCompCounter);
        System.out.println("Rewrite Counter: " + mergeSortRewriteCounter);
        return result;
    }

    private static int[] mergeSort(int[] array, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            int[] result = new int[1];
            result[0] = array[startIdx];
            return result;
        }

        int splitIdx = startIdx + (endIdx - startIdx) / 2;
        return merge(
                mergeSort(array, startIdx, splitIdx),
                mergeSort(array, splitIdx + 1, endIdx)
        );
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIdx = 0, rightIdx = 0, resultIdx = 0;
        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                result[resultIdx] = left[leftIdx];
                leftIdx++;
            } else {
                result[resultIdx] = right[rightIdx];
                rightIdx++;
            }
            mergeSortCompCounter++;
            mergeSortRewriteCounter++;
            resultIdx++;
        }

        while (leftIdx < left.length) {
            result[resultIdx] = left[leftIdx];
            leftIdx++;
            mergeSortRewriteCounter++;
            resultIdx++;
        }
        while (rightIdx < right.length) {
            result[resultIdx] = right[rightIdx];
            rightIdx++;
            mergeSortRewriteCounter++;
            resultIdx++;
        }

        return result;
    }

    public static int[] quickSort(int[] arr) {
        System.out.println("\nQuick sort");
        quickSortCompCounter = 0;
        quickSortRewriteCounter = 0;
        int[] copyArr = arr.clone();
        quickSort(copyArr, 0, copyArr.length - 1);
        System.out.println("Comp counter: " + quickSortCompCounter);
        System.out.println("Rewrite Counter: " + quickSortRewriteCounter);
        return copyArr;
    }

    private static void quickSort(int[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;
        int pivotIdx = partition(arr, startIdx, endIdx);
        quickSort(arr, startIdx, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, endIdx);
    }

    private static int partition(int[] arr, int startIdx, int endIdx) {
        int pivotIdx = startIdx + new Random().nextInt(endIdx - startIdx + 1);
        int pivot = arr[pivotIdx];
        swap(arr, pivotIdx, endIdx);
        quickSortRewriteCounter += 3;
        int i = startIdx;
        for (int j = startIdx; j < endIdx; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                quickSortCompCounter++;
                quickSortRewriteCounter += 3;
                i++;
            }
        }
        swap(arr, i, endIdx);
        quickSortRewriteCounter += 3;
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void demo1() {
        Random rand = new Random();
        int[] array = new int[20];
        int[] sortedArray;

        System.out.println("Original array");
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
            System.out.print(array[i] + " ");
        }

        sortedArray = selectionSort(array);

        sortedArray = insertionSort(array);

        sortedArray = mergeSort(array);

        sortedArray = quickSort(array);

//        System.out.println();
//        for (int i = 0; i < sortedArray.length; i++)
//            System.out.print(sortedArray[i] + " ");

    }

    public static void main(String[] args) {
        demo1();
    }

}
