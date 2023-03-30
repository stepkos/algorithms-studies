package ex4;

public interface IStack<E> {
    boolean isEmpty();
    E pop(); // zwraca i usuwa
    E peek(); // zwraca bez usuwania
    void push(E element);
    int size();
}
