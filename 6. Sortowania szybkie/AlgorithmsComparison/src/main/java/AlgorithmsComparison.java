import java.util.Random;

public class AlgorithmsComparison {

    public static int[] selectionSort(int[] array) {
        int[] result = array.clone();
        for (int i = 0; i < result.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[minIdx]) {
                    minIdx = j;
                }
            }
            int tmp = result[i];
            result[i] = result[minIdx];
            result[minIdx] = tmp;
        }
        return result;
    }

    public static int[] insertionSort(int[] array) {
        int[] result = array.clone();
        for (int i = 1; i < result.length; i++) {
            int j = i;
            while (j > 0 && result[j - 1] > result[j]) {
                int tmp = result[j];
                result[j] = result[j - 1];
                result[j - 1] = tmp;
                j--;
            }
        }
        return result;
    }

    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
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
            }
            else {
                result[resultIdx] = right[rightIdx];
                rightIdx++;
            }
            resultIdx++;
        }

        while (leftIdx < left.length) {
            result[resultIdx] = left[leftIdx];
            leftIdx++;
            resultIdx++;
        }
        while (rightIdx < right.length) {
            result[resultIdx] = right[rightIdx];
            rightIdx++;
            resultIdx++;
        }

        return result;
    }

    public static int[] quickSort(int[] originalArr) {
        int[] arr = originalArr.clone();
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int startIdx, int endIdx) {
        if (endIdx - startIdx <= 1) return;
        int partition = partition(arr, startIdx, endIdx);
        quickSort(arr, startIdx, partition);
        quickSort(arr, partition + 1, endIdx);
    }

    private static int partition(int[] arr, int startIdx, int endIdx) {
        int pivotIdx = startIdx + new Random().nextInt(endIdx - startIdx + 1);
        int pivot = arr[pivotIdx];
        swap(arr, pivotIdx, endIdx);
        int left = startIdx;
        int right = endIdx - 1;
        while (left <= right) {
            while (left <= right && arr[left] - pivot <= 0) left++;
            while (left <= right && arr[right] - pivot > 0) right--;
            if (left < right) swap(arr, left, right);
        }
        swap(arr, left, endIdx);
        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        if (left == right) return;
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    private static void demo1() {
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
            array[i] = new Random().nextInt(100);

        int[] sortedArray = quickSort(array);

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.println();
        for (int i = 0; i < sortedArray.length; i++)
            System.out.print(sortedArray[i] + " ");

    }

    public static void main(String[] args) {
        demo1();
    }

}
