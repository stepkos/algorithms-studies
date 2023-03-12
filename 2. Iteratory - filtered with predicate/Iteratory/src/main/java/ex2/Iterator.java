package ex2;

public interface Iterator<T> {
    void first();
    void last();
    void next();
    void previous();
    boolean isDone();
    T current();
}
