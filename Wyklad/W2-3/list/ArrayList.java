package aisd.list;

import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList<E> extends AbstractList<E> {

	/** <b> domy�lna </b> wielko�� pocz�tkowa tablicy */
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	/** <b> bie��ca </b> wielko�� tablicy */
	private final int _initialCapacity;
	/** referencja na tablic� zawieraj�c� elementy */
	private E[] _array;
	/** rozmiar tablicy traktowanej jako lista */
	private int _size;

//	@SuppressWarnings("unchecked")
	public  ArrayList(int capacity){
		if(capacity<=0)
			capacity=DEFAULT_INITIAL_CAPACITY;
		_initialCapacity=capacity;
		_array=(E[])(new Object[capacity]);
		_size=0;
	}

	public  ArrayList(){
		this(DEFAULT_INITIAL_CAPACITY);
	}

	// metody dodatkowe 
	
	/** rozszerzenie tablicy je�li za ma�o miejsca w obecnej */
	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		if (_array.length < capacity) {
			E[] copy = (E[])(new Object[capacity + capacity / 2]);
			System.arraycopy(_array, 0, copy, 0, _size);
			_array = copy;
		}
	}
	
	// sprawdzenie poprawno�ci indeksu
	private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>=_size) throw new IndexOutOfBoundsException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		_array=(E[])(new Object[_initialCapacity]);
		_size=0;
	}

	@Override
	public boolean isEmpty() {
		return _size==0;
	}

	@Override
	public int size() {
		return _size;
	}
	
	@Override
	public boolean add(E value) {
		ensureCapacity(_size+1);
		_array[_size]=value;
		_size++;
		return true;
	}

	@Override
	public boolean add(int index, E value) {
		if(index<0 || index>_size) throw new IndexOutOfBoundsException();
		ensureCapacity(_size+1);
		if(index!=_size)
			System.arraycopy(_array, index, _array, index+1, _size - index);
		_array[index]=value;
		_size++;
		return false;
	}

	@Override
	public int indexOf(E value) {
		int i =0;
		while(i < _size && !value.equals(_array[i]))
			++i;
		return i<_size ? i : -1;
	}

	@Override
	public boolean contains(E value) {
		return indexOf(value) != -1;
	}

	@Override
	public E get(int index) {
		checkOutOfBounds(index);
		return _array[index];
	}

	@Override
	public E set(int index, E element) {
		checkOutOfBounds(index);
		E retValue=_array[index];
		_array[index]=element;
		return retValue;
	}

	@Override
	public E remove(int index) {
		checkOutOfBounds(index);
		E retValue = _array[index];
		int copyFrom = index + 1;
		if (copyFrom < _size)
			System.arraycopy(_array, copyFrom, _array, index, _size - copyFrom);
		--_size;
		return retValue;
	}

	@Override
	public boolean remove(E value) {
		int pos=0;
		while(pos<_size && !_array[pos].equals(value))
			pos++;
		if(pos<_size){
			remove(pos);
			return true;
		}
		return false;			
	}


	private class InnerIterator implements Iterator<E>{

		int _pos=0;
		@Override
		public boolean hasNext() {
			return _pos<_size;
		}

		@Override
		public E next() {			
			return _array[_pos++];
		}
		
	}
	





	@Override
	public Iterator<E> iterator() {
		return new InnerIterator();
	}
	

	@Override
	public ListIterator<E> listIterator() {
		return new InnerListIterator();
	}
		
	/** iterator stoi "<b>pomi�dzy</b>" elementami i tak trzeba go zaimplementowa�.
	 * Zaimplentowane zostan� tylko operacje <i>niemodyfikuj�ce</i> struktur� */
	private class InnerListIterator implements ListIterator<E>{
		int _pos=0;
		@Override
		public void add(E Value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return _pos<_size;
		}

		@Override
		public boolean hasPrevious() {
			
			return _pos>=0;
		}

		@Override
		public E next() {
			return _array[_pos++];
		}

		@Override
		public int nextIndex() {
			return _pos;
		}

		@Override
		public E previous() {
			return _array[--_pos];
		}

		@Override
		public int previousIndex() {
			return _pos-1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();			
		}
		
	}

}
