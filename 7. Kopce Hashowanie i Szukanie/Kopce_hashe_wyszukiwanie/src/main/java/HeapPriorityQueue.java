import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapPriorityQueue<T> {
    private final List<T> list;
    private final Comparator<T> comparator;

    public HeapPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        list = new ArrayList<T>();
    }

    public HeapPriorityQueue(Comparator<T> comparator, List<T> list) {
        this.comparator = comparator;
        this.list = list;
        for (int i = list.size() / 2; i >= 0; i--) {
            sink(i);
        }
    }

    public void enqueue(T value) {
        list.add(value);
        swim(list.size() - 1);
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T first() {
        return isEmpty() ? null : list.get(0);
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T result = list.get(0);
        if (list.size() > 1) {
            list.set(0, list.get(list.size() - 1));
            sink(0);
        }
        list.remove(list.size() - 1);
        return result;
    }

    public void changePriority(int index, T value) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        list.set(index, value);
        swim(index);
        sink(index);
    }

    public T remove(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        T result = list.get(index);
        int last = list.size() - 1;
        swap(index, last);
        list.remove(last);
        if (index == last) {
            return result;
        }
        T newValue = list.get(index);
        sink(index);
        if (list.get(index).equals(newValue)) {
            swim(index);
        }
        return result;
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    // wynoszenie elementu w gorę - wersja iteracyjna
    private void swim(int index) {
        int parent;
        while (index != 0 && comparator.compare(list.get(index), list.get(parent = (index - 1) / 2)) > 0) {
            swap(index, parent);
            index = parent;
        }
    }

    // opuszczanie elementu w dol stogu - wersja iteracyjna
    private void sink(int index) {
        boolean isDone = false;
        int child;
        while (!isDone && (child = 2 * index + 1) < list.size()) {
            if (child < list.size() - 1 && comparator.compare(list.get(child), list.get(child + 1)) < 0)
                ++child;
            if (comparator.compare(list.get(index), list.get(child)) < 0) {
                swap(index, child);
                index = child;
            } else
                isDone = true;
        }
    }

    @Override
    public String toString() {
        return "HeapPriorityQueue{" +
                "list=" + list.toString() +
                '}';
    }

}