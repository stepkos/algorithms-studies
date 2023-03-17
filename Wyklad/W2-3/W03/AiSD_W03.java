package aisd.W03;

import java.util.ListIterator;

import aisd.list.ArrayList;
import aisd.list.TwoWayCycledListWithSentinel;

public class AiSD_W03 {
	
	
	public static void test1(){
		ArrayList<Integer> lista=new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(2,10);
		lista.add(6,20);
		System.out.println(lista);
		lista.remove(0);
		lista.remove(2);
		lista.remove(4);
		System.out.println(lista);
		
	}
	
	public static void testListaStudentow(){
		TwoWayCycledListWithSentinel<Student> lista=new TwoWayCycledListWithSentinel<>();
		lista.add(new Student(4,1000));
		lista.add(new Student(5,500));
		lista.add(new Student(20,0));
		lista.add(1,new Student(1, 300));
		lista.remove(0);
		lista.remove(new Student(20,10000));
		System.out.println(lista);
		ListIterator<Student> iter=lista.listIterator();
		iter.add(new Student(100,400));
		iter.next();
		iter.add(new Student(101, 600));
		iter.next();
		iter.remove();
		System.out.println(iter.hasNext());
		System.out.println(lista);
		iter.previous();
		iter.remove();
		iter.add(new Student(102,800));
		iter.previous();
		iter.previous();
		iter.previous();
		System.out.println(iter.hasPrevious());
		iter.add(new Student(103,1200));
		System.out.println(iter.hasPrevious());
		System.out.println(lista);				
	}

	public static void main(String[] args) {
		testListaStudentow();
	}

}
