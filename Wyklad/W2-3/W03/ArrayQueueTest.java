package aisd.W03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import aisd.queue.ArrayQueue;
import aisd.queue.EmptyQueueException;
import aisd.queue.FullQueueException;

public class ArrayQueueTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testArrayQueueEmptyAndOneElements() {
		final int howManyElements=100;
		ArrayQueue<Integer> queue=new ArrayQueue<Integer>(3);
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		try {
			for(int i=0;i<howManyElements;i++){
				queue.enqueue(i);
				assertFalse(queue.isEmpty());
				assertFalse(queue.isFull());
				int value=queue.dequeue();
				assertTrue(queue.isEmpty());
				assertFalse(queue.isFull());
				assertEquals(i, value);
			}
		} catch (FullQueueException | EmptyQueueException e) {
			fail("exception!");
		}
	}

	@Test
	public void testArrayQueueTwoAndThreeElements() {
		final int howManyElements=100;
		ArrayQueue<Integer> queue=new ArrayQueue<Integer>(3);
		try {
			queue.enqueue(0);
			queue.enqueue(1);
			for(int i=2;i<howManyElements;i++){
				queue.enqueue(i);
				assertFalse(queue.isEmpty());
				assertTrue(queue.isFull());
				int value=queue.dequeue();
				assertFalse(queue.isEmpty());
				assertFalse(queue.isFull());
				assertEquals(i-2, value);
			}
		} catch (FullQueueException | EmptyQueueException e) {
			fail("exception!");
		}
	}

	@Test
	public void testArrayQueueExceptions() {
		ArrayQueue<Integer> queue=new ArrayQueue<Integer>(3);
		try {
			queue.dequeue();
			fail("Exception expected");
		} catch (EmptyQueueException e) {
			// OK, no exception
		}
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
		} catch (FullQueueException e) {
			fail("Exception!");
		}
		try{
			queue.enqueue(4);
			fail("Exception expected");
		} catch (FullQueueException e) {
			// OK, no exception
		}
	}

	@Test
	public void testArrayQueueExceptions2() {
		ArrayQueue<Integer> queue=new ArrayQueue<Integer>(3);
		try {
			queue.dequeue();
			fail("Exception expected");
		} catch (EmptyQueueException e) {
			// OK, no exception
		}
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.dequeue();
			queue.enqueue(4);
		} catch (Exception e) {
			fail("Exception!");
		}
		try{
			queue.enqueue(100);
			fail("Exception expected");
		} catch (FullQueueException e) {
			// OK, no exception
		}
		try {
			queue.dequeue();
			queue.enqueue(5);
		} catch (Exception e) {
			fail("Exception!");
		}
		try{
			queue.enqueue(100);
			fail("Exception expected");
		} catch (FullQueueException e) {
			// OK, no exception
		}
	}
}
