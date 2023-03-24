package ex1;

public interface IQueue<E> {
    void push(E element);
    E pop();
    E peek();
    int size();
}
