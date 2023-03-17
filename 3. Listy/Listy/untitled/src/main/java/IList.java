import java.util.Iterator;
import java.util.ListIterator;

public interface IList<E> {
    boolean add(E element); // dodanie elementu na koniec listy
    boolean insert(int index, E element); // dodanie elementu na podanej pozycji
    void clear(); // usuniecie wszystkich elementów
    boolean contains(E element); // czy lista zawiera podany element (equals())
    E get(int index); // pobranie elementu z podanej pozycji
    int indexOf(E element); // pozycja szukanego elementu
    boolean isEmpty(); // czy lista jest pusta
    E removeFirst(); // usuwa pierwszy element
    E removePos(int index); // usuwa element z podanej pozycji
    int size(); // zwraca rozmiar listy
    void display(); // wyswietla wszystkie elementy listy
}