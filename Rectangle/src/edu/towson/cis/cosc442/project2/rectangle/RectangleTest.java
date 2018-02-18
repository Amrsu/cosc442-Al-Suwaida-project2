package edu.towson.cis.cosc442.project2.rectangle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The unit test Class for Rectangle.
 */
public class RectangleTest {
	
	/** Declaring necessary test objects for {@link Rectangle} */
	Rectangle rect1, rect2;

	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		rect1 = new Rectangle(new Point(2.0, 2.0), new Point(4.0, 5.0));
		rect2 = new Rectangle(new Point(2.0, 4.0), new Point(6.0, 3.0));
	}

	/**
	 * Test for the getArea() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetArea() {
		assertEquals(6.0, rect1.getArea(),6.0);
		assertEquals(2.0, rect2.getArea(),2.0);
	}

	/**
	 * Test for the getDiagonal() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetDiagonal() {
		assertEquals(3.61, rect1.getDiagonal(), 3.61);
		assertEquals(2.24, rect2.getDiagonal(), 2.24);
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown(){
		rect1 = null;
		rect2 = null;
	}
}
