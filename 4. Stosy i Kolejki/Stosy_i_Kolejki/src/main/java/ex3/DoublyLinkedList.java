package ex3;

public class DoublyLinkedList<T> {
    private Element<T> head;
    private Element<T> tail;

    private static class Element<T> {
        T data;
        Element<T> next;
        Element<T> prev;

        Element(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void add(T data) {
        Element<T> newElement = new Element<>(data);

        if (head == null) {
            // Lista jest pusta
            head = tail = newElement;
        } else {
            // Dodajemy na koniec
            tail.next = newElement;
            newElement.prev = tail;
            tail = newElement;
        }
    }

    public void display() {
        Element<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void linkAtEnd(DoublyLinkedList<T> linkedList) {
        if (linkedList.head == null) return;
        if (head == null) {
            head = linkedList.head;
            tail = linkedList.tail;
        }
        else {
            tail.next = linkedList.head;
            linkedList.head.prev = tail;
            tail = linkedList.tail;
        }
    }

    public void linkAtBeginning(DoublyLinkedList<T> linkedList) {
        if (linkedList.head == null) return;
        if (head == null) {
            head = linkedList.head;
            tail = linkedList.tail;
        }
        else {
            head.prev = linkedList.tail;
            linkedList.tail.next = head;
            head = linkedList.head;
        }
    }

}
