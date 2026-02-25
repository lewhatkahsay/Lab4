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
	 * tests that isEmpty() returns false when an element is added (list is not
	 * empty)
	 */
	@Test
	void testIsEmptyAfterAdd() {
		l.add(1);
		assertFalse(l.isEmpty());
	}

}
