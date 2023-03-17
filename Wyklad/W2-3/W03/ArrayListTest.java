package aisd.W03;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import aisd.list.ArrayList;

public class ArrayListTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() {
		ArrayList<String> strList1=new ArrayList<>();
		forTestCreate(strList1);
		ArrayList<String> strList2=new ArrayList<>(5);
		forTestCreate(strList2);
	}
	
	public <T> void forTestCreate(ArrayList<T> arrList){
		assertNotNull(arrList);
		assertTrue(arrList.isEmpty());
		assertEquals(0, arrList.size());
		assertEquals("[]",arrList.toString());
		arrList.clear();
		assertTrue(arrList.isEmpty());
		assertEquals(0, arrList.size());
		Iterator<T> iter=arrList.iterator();
		assertNotNull(iter);
		assertEquals("[]",arrList.toString());
	}
	
	@Test
	public void testCreate0() {
		ArrayList<String> strList=new ArrayList<>(0);
		forTestCreate(strList);
	}

	@Test
	public void testAdd1() {
		ArrayList<String> strList=new ArrayList<>(1);
		forTestCreate(strList);
		try{
			strList.add(1, "jeden");
			fail("Wyj¹tek nie wygenerowany!!!!");
		}
		catch(IndexOutOfBoundsException e){
			// OK
		}
		strList.add(0, "jeden");
		assertFalse(strList.isEmpty());
		assertEquals(1, strList.size());
		strList.add("dwa");
		assertFalse(strList.isEmpty());
		assertEquals(2, strList.size());
		assertEquals("[jeden, dwa]",strList.toString());
		try{
			strList.add(3, "cztery");
			fail("Wyj¹tek nie wygenerowany!!!!");
		}
		catch(IndexOutOfBoundsException e){
			// OK
		}
		try{
			strList.add(-1, "minusJeden");
			fail("Wyj¹tek nie wygenerowany!!!!");
		}
		catch(IndexOutOfBoundsException e){
			// OK
		}
		assertFalse(strList.isEmpty());
		assertEquals(2, strList.size());
		assertEquals("[jeden, dwa]",strList.toString());
	}
	
	public void testClear() {
		ArrayList<String> strList=new ArrayList<>(1);
		strList.add(0, "jeden");
		strList.add("dwa");
		strList.clear();
		assertTrue(strList.isEmpty());
		assertEquals(0, strList.size());
		assertEquals("[]",strList.toString());
	}

	@Test
	public void testAdd() {
		ArrayList<String> strList=new ArrayList<>(3);
		forTestCreate(strList);
		strList.add("jeden");
		assertFalse(strList.isEmpty());
		assertEquals(1, strList.size());
		strList.add("dwa");
		assertFalse(strList.isEmpty());
		assertEquals(2, strList.size());
		strList.add("trzy");
		assertFalse(strList.isEmpty());
		assertEquals(3, strList.size());
		assertEquals("[jeden, dwa, trzy]",strList.toString());
		}
}
