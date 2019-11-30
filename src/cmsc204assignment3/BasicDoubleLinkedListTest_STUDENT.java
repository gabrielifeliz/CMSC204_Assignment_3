package cmsc204assignment3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student JUnit for testing basic doubly-linked list
 * @author Gabriel I Feliz
 */
public class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<Double> linkedDouble;
	DoubleComparator comparatorD;

	@Before
	public void setUp() throws Exception {
		
		//STUDENT: Use the linkedDouble for the STUDENT tests
		linkedDouble = new BasicDoubleLinkedList<Double>();
		//add doubles to the linkedDouble list
		linkedDouble.addToEnd(52.0);
		linkedDouble.addToEnd(45.0);
		
		comparatorD = new DoubleComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedDouble = null;
		comparatorD = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedDouble.getSize());
	}
	
	@Test
	public void testAddToEndSTUDENT(){
		//test addToEnd for the linkedDouble
		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToEnd(19.0);
		assertEquals(new Double(19.0), linkedDouble.getLast());
	}

	@Test
	public void testAddToFrontSTUDENT(){
		//test addToFront for the linkedDouble
		assertEquals(new Double(52.0), linkedDouble.getFirst());
		linkedDouble.addToFront(21.0);
		assertEquals(new Double(21.0), linkedDouble.getFirst());
	}

	@Test
	public void testGetFirstSTUDENT(){
		//test getFirst for the linkedDouble
		assertEquals(new Double(52.0), linkedDouble.getFirst());
		linkedDouble.addToFront(12.0);
		assertEquals(new Double(12.0), linkedDouble.getFirst());
	}

	@Test
	public void testGetLastSTUDENT(){
		//test getLast for the linkedDouble
		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToEnd(78.0);
		assertEquals(new Double(78.0), linkedDouble.getLast());
	}
	
	@Test
	public void testToArraySTUDENT(){
		//test toArray for the linkedDouble
		ArrayList<Double> list;
		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		list = linkedDouble.toArrayList();
		assertEquals(new Double(21.0), list.get(0));
		assertEquals(new Double(52.0), list.get(1));
		assertEquals(new Double(45.0), list.get(2));
		assertEquals(new Double(19.0), list.get(3));
	}
	
	@Test
	public void testIteratorSuccessfulNextSTUDENT(){
		//test the iterator for the linkedDouble
		//be throughal, use the corresponding test method in the provided 
		//JUnit test an example
		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
	}
	
	@Test
	public void testIteratorSuccessfulPreviousSTUDENT(){
		//test the iterator for the linkedDouble
		//be throughal, use the corresponding test method in the provided 
		//JUnit test an example
		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
                assertEquals(true, iterator.hasPrevious());
                assertEquals(new Double(45.0), iterator.previous());		
		assertEquals(new Double(52.0), iterator.previous());
	}
	
	
	@Test
	public void testIteratorNoSuchElementExceptionNextSTUDENT(){
		//test the iterator for the linkedDouble.  Exception raised
		//when next is called after last element.
		//be throughal, use the the corresponding test method in the provided 
		//JUnit test an example
		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
                try {
			//no more elements in list
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException",true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPreviousSTUDENT(){
		//test the iterator for the linkedDouble.  Exception raised
		//when prvious is called when before the first element.
		//be throughal, use the the corresponding test method in the provided 
		//JUnit test an example
		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(new Double(19.0), iterator.next());
		assertEquals(false, iterator.hasNext());
                assertEquals(true, iterator.hasPrevious());
 		assertEquals(new Double(19.0), iterator.previous());
                assertEquals(new Double(45.0), iterator.previous());
		assertEquals(new Double(52.0), iterator.previous());
 		assertEquals(new Double(21.0), iterator.previous());
                try {
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException",true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}	
        }

	@Test
	public void testIteratorUnsupportedOperationExceptionSTUDENT(){
		//test the remove method for the iterator for the linkedDouble
		//be throughal, use the the corresponding test method in the provided 
		//JUnit test an example
		linkedDouble.addToFront(21.0);
		linkedDouble.addToEnd(19.0);
		ListIterator<Double> iterator = linkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(21.0), iterator.next());
		assertEquals(new Double(52.0), iterator.next());
		assertEquals(new Double(45.0), iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(new Double(19.0), iterator.next());
                try {
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	@Test
	public void testRemoveSTUDENT(){
		//test the remove method for the linkedDouble
		//be throughal, remove from the front of the list, the
		//end of the list and the middle of the list, 
		//use the the corresponding test method in the provided 
		//JUnit test an example
		assertEquals(new Double(52.0), linkedDouble.getFirst());
		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToFront(21.0);
		assertEquals(new Double(21.0), linkedDouble.getFirst());
		linkedDouble.remove(21.0, comparatorD);
		assertEquals(new Double(52.0), linkedDouble.getFirst());
		//remove from the end of the list
		linkedDouble.addToEnd(19.0);
		assertEquals(new Double(19.0), linkedDouble.getLast());
		linkedDouble.remove(19.0, comparatorD);
		assertEquals(new Double(45.0), linkedDouble.getLast());
		//remove from middle of list
		linkedDouble.addToFront(38.0);
		assertEquals(new Double(38.0), linkedDouble.getFirst());
		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.remove(52.0, comparatorD);
		assertEquals(new Double(38.0), linkedDouble.getFirst());
		assertEquals(new Double(45.0), linkedDouble.getLast());
	}
	
	@Test
	public void testRetrieveFirstElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals(new Double(52.0), linkedDouble.getFirst());
		linkedDouble.addToFront(21.0);
		assertEquals(new Double(21.0), linkedDouble.getFirst());
		assertEquals(new Double(21.0), linkedDouble.retrieveFirstElement());
		assertEquals(new Double(52.0),linkedDouble.getFirst());
		assertEquals(new Double(52.0), linkedDouble.retrieveFirstElement());
		assertEquals(new Double(45.0),linkedDouble.getFirst());
	}
	
	@Test
	public void testRetrieveLastElementSTUDENT(){
		//test retrieveLastElement for linkedDouble
		assertEquals(new Double(45.0), linkedDouble.getLast());
		linkedDouble.addToEnd(19.0);
		assertEquals(new Double(19.0), linkedDouble.getLast());
		assertEquals(new Double(19.0), linkedDouble.retrieveLastElement());
		assertEquals(new Double(45.0),linkedDouble.getLast());
	}

	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}