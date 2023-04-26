public class PriorityQueue<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    public PriorityQueue() {
        heap = (T[]) new Comparable[16];
        size = 0;
    }

    public void enqueue(T item) {
        if (size == heap.length - 1) {
            resize();
        }

        size++;
        heap[size] = item;
        bubbleUp(size);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        T item = heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        bubbleDown(1);
        return item;
    }

    public void changePriority(int index, T newPriority) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        T oldPriority = heap[index];
        heap[index] = newPriority;

        if (newPriority.compareTo(oldPriority) < 0) {
            bubbleUp(index);
        } else {
            bubbleDown(index);
        }
    }

    public void remove(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        heap[index] = heap[size];
        heap[size] = null;
        size--;
        bubbleDown(index);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        T[] newHeap = (T[]) new Comparable[heap.length * 2];
        System.arraycopy(heap, 1, newHeap, 1, size);
        heap = newHeap;
    }

    private void bubbleUp(int index) {
        int parent = index / 2;

        while (index > 1 && heap[index].compareTo(heap[parent]) < 0) {
            swap(index, parent);
            index = parent;
            parent = index / 2;
        }
    }

    private void bubbleDown(int index) {
        int child = index * 2;

        while (child <= size) {
            if (child < size && heap[child + 1].compareTo(heap[child]) < 0) {
                child++;
            }

            if (heap[index].compareTo(heap[child]) > 0) {
                swap(index, child);
                index = child;
                child = index * 2;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
