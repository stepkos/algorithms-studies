import java.util.Iterator;
import java.util.ListIterator;

public class LinkedList<E> implements IList<E> {

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
    int size;

    public LinkedList() { }

    private Element getElement(int index) {
        index %= size;
        Element currentElement = head;

        while (index > 0 && currentElement != null) {
            index--;
            currentElement = currentElement.getNext();
        }

        if (currentElement==null)
            throw new IndexOutOfBoundsException();
        return currentElement;
    }

    @Override
    public boolean add(E element) {
        size++;
        Element newElement = new Element(element);
        if (head == null) {
            head = newElement;
            return true;
        }

        Element tail=head;
        while (tail.getNext() != null)
            tail=tail.getNext();

        tail.setNext(newElement);
        return true;
    }

    @Override
    public boolean insert(int index, E element) {
        index %= size;
        size++;
        Element newElement = new Element(element);

        if (index == 0) {
            newElement.setNext(head);
            head = newElement;
            return true;
        }

        Element prefElement = getElement(index-1);
        newElement.setNext(prefElement.getNext());
        prefElement.setNext(newElement);
        return true;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public E get(int index) {
        return getElement(index % size).getValue();
    }

    @Override
    public int indexOf(E element) {
        int position = 0;
        Element currentElement = head;
        while (currentElement != null) {
            if (currentElement.getValue().equals(element))
                return position;
            position++;
            currentElement = currentElement.getNext();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public E removeFirst() {
        if (head == null) throw new IndexOutOfBoundsException();
        size--;
        E retValue = head.getValue();
        head = head.getNext();
        return retValue;
    }

    @Override
    public E removePos(int index) {
        if (head == null) throw new IndexOutOfBoundsException();
        index %= size;
        size--;
        if (index == 0) {
            E retValue = head.getValue();
            head = head.getNext();
            return retValue;
        }

        Element actElem = getElement(index-1);
        if (actElem.getNext() == null)
            throw new IndexOutOfBoundsException();
        E retValue=actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());
        return retValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Element element = head;
        while (element != null) {
            System.out.println(element.getValue());
            element = element.getNext();
        }
    }

}
