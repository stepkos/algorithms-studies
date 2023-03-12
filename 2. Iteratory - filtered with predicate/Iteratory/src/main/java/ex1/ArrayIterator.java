package ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] arr;
    private int pos = 0;

    public ArrayIterator(T[] arr) {
        this.arr = arr;
    }

    public boolean hasNext() {
        return pos < arr.length;
    }

    public T next() throws NoSuchElementException {
        if (hasNext())
            return arr[pos++];
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
