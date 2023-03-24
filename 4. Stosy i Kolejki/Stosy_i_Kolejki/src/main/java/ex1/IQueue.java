package ex1;

public interface IQueue<E> {
    void push(E element);
    E pop(); // zwraca i usuwa
    E peek(); // zwraca bez usuwania
    int size();
    boolean isEmpty();
}
