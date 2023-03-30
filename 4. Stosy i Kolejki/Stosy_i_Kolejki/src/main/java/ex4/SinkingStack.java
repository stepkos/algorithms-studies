package ex4;

public class SinkingStack<E> implements IStack<E> {

    private E arr[];
    private int capacity;
    private int top = 0;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public SinkingStack(int capacity) {
        this.capacity = capacity;
        arr = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E pop() {
        if (size == 0) return null;
        if (top == 0) top=capacity;
        size--;
        return arr[--top];
    }

    @Override
    public E peek() {
        if (size == 0) return null;
        if (top == 0) top = capacity;
        return arr[top-1];
    }

    @Override
    public void push(E element) {
        if (top == capacity) top=0;
        arr[top++] = element;
        if (capacity > size) size++;
    }

    @Override
    public int size() {
        return size;
    }

}
