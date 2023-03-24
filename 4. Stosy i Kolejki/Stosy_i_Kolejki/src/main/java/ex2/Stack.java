package ex2;

import ex1.Queue;

public class Stack<E> implements IStack<E> {

    private class Element {
        private E value;
        private Element next;

        Element(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public Element getNext() {
            return next;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public void setNext(Element next) {
            this.next = next;
        }

    }

    Element head = null;

    @Override
    public E pop() {
        if (head == null)
            return null;

        E value = head.getValue();
        head = head.getNext();
        return value;
    }

    @Override
    public E peek() {
        if (head == null)
            return null;
        return head.getValue();
    }

    @Override
    public void push(E element) {
        Element newElement = new Element(element);
        newElement.setNext(head);
        head = newElement;
    }

    @Override
    public int size() {
        int position = 0;
        Element currentElement = head;
        while (currentElement != null) {
            position++;
            currentElement = currentElement.getNext();
        }
        return position;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
