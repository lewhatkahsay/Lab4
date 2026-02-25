package basic;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

class SinglyLinkedListTest {

	SinglyLinkedList<Integer> l; // the singly linked list object we will use to test our code

	/**
	 * @BeforeEach before the setUp() method indicates that this code will run
	 *             before each test
	 *             In this case, we instantiate the object l of type
	 *             SinglyLinkedList<Integer>
	 */
	@BeforeEach
	public void setUp() {
		l = new SinglyLinkedList<Integer>();
	}

	// mark all tests with @Test
	/**
	 * tests that a new list is empty
	 */
	@Test
	void testConstructor() {
		assertTrue(l.isEmpty());
	}

	/**
	 * Note this technically is testing both addFirst
	 * and getFirst at the same time.
	 */
	@Test
	void testAdd() {
		l.add(1);
		assertEquals(l.get(0), 1);

		l.add(2);
		assertEquals(l.get(0), 2);

		l.add(3);
		assertEquals(l.get(0), 3);
	}

	// the convention is to name methods as test+name of method to test + any
	// particular subcase
	// e.g., here, test the get method, specifically what happens when requesting an
	// index out of bounds
	/**
	 * tests that get() throws an IndexOutOfBoundsException for indexes out of range
	 */
	@Test
	void testGetRange() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.get(1);
		});
	}

	/**
	 * tests that size method returns 0 for an empty list and increases with each
	 * element added
	 */
	@Test
	void testSize() {
		assertEquals(l.size(), 0);
		l.add(1);
		assertEquals(l.size(), 1);
		l.add(2);
		assertEquals(l.size(), 2);
	}

	/**
	 * tests add(int, E) in the middle of a list
	 */
	@Test
	void testAddAtMiddleIndex() {
		l.add(1);
		l.add(2);
		l.add(1, 3);
		assertEquals(l.get(0), 2);
		assertEquals(l.get(1), 3);
		assertEquals(l.get(2), 1);
	}

	/**
	 * tests that add(int, E) throws IndexOutOfBoundsException for an empty list
	 */
	@Test
	void testAddAtIndexEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.add(1, 1);
		});
	}

	/**
	 * tests that get() returns the correct element
	 */
	@Test
	void testGet() {
		l.add(1);
		l.add(2);
		l.add(3);
		assertEquals(l.get(0), 3);
		assertEquals(l.get(1), 2);
		assertEquals(l.get(2), 1);
	}

	/**
	 * tests that set() replaces and returns the element
	 */
	@Test
	void testSet() {
		l.add(1);
		l.add(2);
		assertEquals(l.set(0, 3), 2);
		assertEquals(l.get(0), 3);
	}

	/**
	 * tests that set() throws an IndexOutOfBoundsException for an empty list
	 */
	@Test
	void testSetEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			l.set(0, 1);
		});
	}

	/**
	 * tests that remove() returns and removes the first element
	 */
	@Test
	void testRemove() {
		l.add(1);
		l.add(2);
		assertEquals(l.remove(), 2);
		assertEquals(l.size(), 1);
		assertEquals(l.get(0), 1);
	}

	/**
	 * tests that remove(int) removes the correct element
	 */
	@Test
	void testRemoveIndex() {
		l.add(1);
		l.add(2);
		l.add(3);
		assertEquals(l.remove(1), 2);
		assertEquals(l.size(), 2);
		assertEquals(l.get(0), 3);
		assertEquals(l.get(1), 1);
	}

	/**
	 * tests that remove() throws an exception for an empty list
	 */
	@Test
	void testRemoveEmpty() {
		assertThrows(NullPointerException.class, () -> {
			l.remove();
		});
	}

	/**
	 * tests that clear() empties list and makes size 0
	 */
	@Test
	void testClear() {
		l.add(1);
		l.add(2);
		l.clear();
		assertTrue(l.isEmpty());
		assertEquals(l.size(), 0);
	}

	/**
	 * tests that the iterator traverses correctly
	 */
	@Test
	void testIterator() {
		l.add(1);
		l.add(2);
		l.add(3);
		Iterator<Integer> iterate = l.iterator();
		assertTrue(iterate.hasNext());
		assertEquals(iterate.next(), 3);
		assertEquals(iterate.next(), 2);
		assertEquals(iterate.next(), 1);
		assertFalse(iterate.hasNext());
	}

}
