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

        int tmp_index = index-1;
        tmp_index %= size;
        Element currentElement = head;

        while (tmp_index > 0 && currentElement != null) {
            tmp_index--;
            currentElement = currentElement.getNext();
        }

        if (currentElement==null)
            throw new IndexOutOfBoundsException();
        Element prefElement = currentElement;


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
        int position = 0;
        Element currentElement = head;
        while (currentElement != null) {
            if (currentElement.getValue().equals(element))
                return position >= 0;
            position++;
            currentElement = currentElement.getNext();
        }
        return false;
    }

    @Override
    public E get(int index) {
        int tmp_index = index % size;
        Element currentElement = head;

        while (tmp_index > 0 && currentElement != null) {
            tmp_index--;
            currentElement = currentElement.getNext();
        }

        if (currentElement==null)
            throw new IndexOutOfBoundsException();
        return currentElement.getValue();
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

        int tmp_index = index-1;
        tmp_index %= size;
        Element currentElement = head;

        while (tmp_index > 0 && currentElement != null) {
            tmp_index--;
            currentElement = currentElement.getNext();
        }

        if (currentElement==null)
            throw new IndexOutOfBoundsException();
        Element actElem = currentElement;


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

    // Metody dla zadania 3

    public void displayListRecursive() {
        displayListRecursive(head);
    }

    private void displayListRecursive(Element el) {
        if (el == null) return;
        System.out.println(el.getValue());
        displayListRecursive(el.getNext());
    }

    public void displayListRecursiveReverse() {
        displayListRecursiveReverse(head);
    }

    private void displayListRecursiveReverse(Element el) {
        if (el == null) return;
        displayListRecursiveReverse(el.getNext());
        System.out.println(el.getValue());
    }

    public LinkedList<E> copyListRecursive() {
        LinkedList<E> list = new LinkedList<>();
        copyListRecursive(head, list);
        return list;
    }

    private void copyListRecursive(Element el, LinkedList<E> list) {
        if (el == null)
            return;
        list.add(el.getValue());
        copyListRecursive(el.getNext(), list);
    }

    public E sumRecursive() {
        if (head == null) return null;
        return sumRecursive(head);
    }

    private E sumRecursive(Element el) {
        if (el.getNext() == null)
            return el.getValue();
        return add(sumRecursive(el.getNext()), el.getValue());

    }

    private E add(E e1, E e2) {
        if(e1 instanceof Integer && e2 instanceof Integer)
            return (E) Integer.valueOf(((Integer)e1).intValue() + ((Integer)e2).intValue());
        if(e1 instanceof Double && e2 instanceof Double)
            return (E) Double.valueOf(((Double)e1).doubleValue() + ((Double)e2).doubleValue());
        if(e1 instanceof String && e2 instanceof String)
            return (E) ((String)e1 + (String)e2);
        throw new UnsupportedOperationException("Unsupported for this type");
    }

    public int sizeRecursive() {
        return sizeRecursive(head);
    }

    private int sizeRecursive(Element el) {
        if (el == null)
            return 0;
        return 1 + sizeRecursive(el.getNext());
    }

}
