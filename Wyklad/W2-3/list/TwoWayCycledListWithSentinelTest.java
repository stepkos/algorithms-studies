package aisd.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class TwoWayCycledListWithSentinelTest {

	TwoWayCycledListWithSentinel<Integer> list;
	Iterator<Integer> iter;
	ListIterator<Integer> listIter;

	@Before
	public void setUp() throws Exception {
		list=new TwoWayCycledListWithSentinel<Integer>();
		iter=list.iterator();
		listIter=list.listIterator();
	}

	@Test
	public void NewListTest() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		list.clear();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		try{
			list.get(0);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			// OK
		}
		try{
			list.get(1);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			// OK
		}
		iter=list.iterator();
		assertFalse(iter.hasNext());
		listIter=list.listIterator();
		assertFalse(listIter.hasNext());
		assertFalse(listIter.hasPrevious());
		try{
			list.remove(0);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			// OK
		}
		try{
			list.remove(1);
			fail();
		}
		catch(IndexOutOfBoundsException e){
			// OK
		}
		assertFalse(list.remove(new Integer(0)));
		for(Integer x:list){
			fail(); // nie ma elementu
		}
	}
	
	@Test
	public void iteratorOneElemTest(){
		list.add(10);
		for(Integer x:list){
			assertEquals(new Integer(10), x);
		}
		listIter=list.listIterator();
		assertTrue(listIter.hasNext());
		assertFalse(listIter.hasPrevious());
		int x=listIter.next();
		assertEquals(10, x);
		assertFalse(listIter.hasNext());
		assertTrue(listIter.hasPrevious());
		x=listIter.previous();
		assertEquals(10, x);
		assertTrue(listIter.hasNext());
		assertFalse(listIter.hasPrevious());
	}

	@Test
	public void iteratorThreeElemTest(){
		list.add(10);
		list.add(20);
		list.add(30);
		int factor=0;
		for(Integer x:list){
			assertEquals(new Integer(++factor*10), x);
		}
		listIter=list.listIterator();
		assertTrue(listIter.hasNext());
		assertFalse(listIter.hasPrevious());
		int x=listIter.next();
		assertEquals(10, x);
		assertTrue(listIter.hasNext());
		assertTrue(listIter.hasPrevious());
		x=listIter.next();
		assertEquals(20, x);
		assertTrue(listIter.hasNext());
		assertTrue(listIter.hasPrevious());
		x=listIter.next();
		assertEquals(30, x);
		assertFalse(listIter.hasNext());
		assertTrue(listIter.hasPrevious());
		x=listIter.previous();
		assertEquals(30, x);
		assertTrue(listIter.hasNext());
		assertTrue(listIter.hasPrevious());
		x=listIter.previous();
		assertEquals(20, x);
		assertTrue(listIter.hasNext());
		assertTrue(listIter.hasPrevious());
		x=listIter.previous();
		assertEquals(10, x);
		assertTrue(listIter.hasNext());
		assertFalse(listIter.hasPrevious());
	}
	
	@Test
	public void iteratorAddBeforeHeadTest(){
		list.add(30);
		list.add(40);
		list.add(50);
		listIter=list.listIterator();
		listIter.add(10);
		listIter.add(20);
		int factor=0;
		for(Integer x:list){
			assertEquals(new Integer(++factor*10), x);
		}		
	}
	@Test
	public void iteratorAddAfterHeadTest(){
		list.add(10);
		list.add(40);
		list.add(50);
		listIter=list.listIterator();
		listIter.next();
		listIter.add(20);
		listIter.add(30);
		int factor=0;
		for(Integer x:list){
			assertEquals(new Integer(++factor*10), x);
		}		
	}

	@Test
	public void iteratorAfterTailTest(){
		list.add(10);
		list.add(20);
		list.add(30);
		listIter=list.listIterator();
		listIter.next();
		listIter.next();
		listIter.next();
		listIter.add(40);
		listIter.add(50);
		assertEquals(false,listIter.hasNext());
		assertEquals(new Integer(50),listIter.previous());
		assertEquals(new Integer(40),listIter.previous());
		assertEquals(new Integer(30),listIter.previous());
		assertEquals(new Integer(20),listIter.previous());
		assertEquals(new Integer(10),listIter.previous());
		assertEquals(false,listIter.hasPrevious());
		int factor=0;
		for(Integer x:list){
			assertEquals(new Integer(++factor*10), x);
		}		
	}

	@Test
	public void iteratorAfterPrevious(){
		list.add(10);
		list.add(30);
		list.add(50);
		listIter=list.listIterator();
		listIter.next();
		listIter.next();
		listIter.next();
		assertEquals(new Integer(50),listIter.previous());
		listIter.add(40);
		assertEquals(new Integer(40),listIter.previous());
		assertEquals(new Integer(30),listIter.previous());		
		listIter.add(20);
		assertEquals(new Integer(20),listIter.previous());
		assertEquals(new Integer(10),listIter.previous());		
		listIter.add(0);
		assertEquals(new Integer(0),listIter.previous());		
		assertEquals(false,listIter.hasPrevious());
		int factor=0;
		for(Integer x:list){
			assertEquals(new Integer(factor++*10), x);
		}		
	}

	@Test
	public void iteratorRemoveOneByOne(){
		list.add(10);
		list.add(30);
		list.add(50);
		listIter=list.listIterator();
		listIter.next();
		listIter.remove();
		listIter.next();
		listIter.remove();
		listIter.next();
		listIter.remove();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void insertAtZero(){
		list.add(0,10);
		list.add(0,9);
		list.add(0,8);
		assertEquals("[8, 9, 10]",list.toString());
	}
}
