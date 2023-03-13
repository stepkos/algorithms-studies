package ex1;

import java.util.Iterator;

public final class ArrayFilterIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;
    private final Predicate<T> predicate;
    private T elemNext = null;
    private boolean hasNextVal = true;

    public ArrayFilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
        super();
        this.iterator = iterator;
        this.predicate = predicate;
        findNextValid();
    }

    private void findNextValid() {
        while (iterator.hasNext()) {
            elemNext = iterator.next();
            if (predicate.accept(elemNext)) {
                return;
            }
        }
        hasNextVal = false;
        elemNext = null;
    }

    @Override
    public boolean hasNext() {
        return hasNextVal;
    }

    @Override
    public T next() {
        T nextValue = elemNext;
        findNextValid();
        return nextValue;
    }

}
