package ex2;

public class NumberFilterIterator<T> implements Iterator<T> {

    private final Iterator<T> iterator;
    private final Predicate<T> predicate;
    private T currentElement = null;

    public NumberFilterIterator(Iterator<T> iterator, Predicate<T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        first();
    }

    @Override
    public void next() {
        while (!iterator.isDone()) {
            iterator.next();
            if (predicate.accept(iterator.current())) {
                currentElement = iterator.current();
                return;
            }
        }
        currentElement = null;
    }

    @Override
    public void previous() {
        while (!iterator.isDone()) {
            iterator.previous();
            if (predicate.accept(iterator.current())) {
                currentElement = iterator.current();
                return;
            }
        }
        currentElement = null;
    }

    @Override
    public void first() {
        iterator.first();
        if (predicate.accept(iterator.current()))
            currentElement = iterator.current();
        else
            next();
    }

    @Override
    public void last() {
        iterator.last();
        if (predicate.accept(iterator.current()))
            currentElement = iterator.current();
        else
            previous();
    }

    @Override
    public boolean isDone() {
        return iterator.isDone();
    }

    @Override
    public T current() {
        return currentElement;
    }

}
