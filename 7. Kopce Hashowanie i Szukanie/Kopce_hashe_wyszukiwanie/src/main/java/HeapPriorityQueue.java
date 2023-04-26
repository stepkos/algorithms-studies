import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapPriorityQueue<T> {
    private final List<T> _list;
    private final Comparator<T> _comparator;

    public HeapPriorityQueue(Comparator<T> comparator) {
        _comparator = comparator;
        _list = new ArrayList<T>();
    }

    public void enqueue(T value) {
        _list.add(value);
        swim(_list.size() - 1);
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    public T first() {
        return isEmpty() ? null : _list.get(0);
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T result = _list.get(0);
        if (_list.size() > 1) {
            _list.set(0, _list.get(_list.size() - 1));
            sink(0);
        }
        _list.remove(_list.size() - 1);
        return result;
    }

    private void swap(int index1, int index2) {
        T temp = _list.get(index1);
        _list.set(index1, _list.get(index2));
        _list.set(index2, temp);
    }

    // wynoszenie elementu w gorę - wersja iteracyjna
    private void swim(int index) {
        int parent;
        while (index != 0 && _comparator.compare(_list.get(index), _list.get(parent = (index - 1) / 2)) > 0) {
            swap(index, parent);
            index = parent;
        }
    }

    // opuszczanie elementu w dol stogu - wersja iteracyjna
    private void sink(int index) {
        boolean isDone = false;
        int child;
        while (!isDone && (child = 2 * index + 1) < _list.size()) {
            if (child < _list.size() - 1 && _comparator.compare(_list.get(child), _list.get(child + 1)) < 0)
                ++child;
            if (_comparator.compare(_list.get(index), _list.get(child)) < 0) {
                swap(index, child);
                index = child;
            } else
                isDone = true;
        }
    }
}

