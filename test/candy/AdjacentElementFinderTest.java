/**
 * 
 */
package candy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author faustodelatog
 *
 */
public class AdjacentElementFinderTest {
	
	private AdjacentElementFinder finder;
	private Object[][] board = { 
			{ 1, 2, 4, 2, 6, 7, 8, 5, 3 },
			{ 1, 2, 3, 2, 5, 5, 4, 3, 2 },
			{ 1, 2, 2, 2, 2, 2, 2, 6, 3 }, 
			{ 1, 2, 3, 2, 1, 4, 3, 5, 7 },
			{ 1, 1, 3, 2, 8, 8, 6, 5, 3 }, 
			{ 2, 3, 5, 2, 2, 8, 3, 1, 2 },
			{ 4, 3, 2, 2, 7, 8, 7, 3, 1 }, 
			{ 7, 6, 3, 2, 9, 8, 8, 3, 4 },
			{ 2, 4, 5, 6, 6, 7, 7, 2, 1 } };

	@Before
	public void initTest() {
		finder = new AdjacentElementFinder(board);
	}

	@Test
	public void shouldFindThreeEqualsAdjacentElements() {
		Coordinate element = new Coordinate(3, 6);

		List<Coordinate> expectedElements = new ArrayList<Coordinate>();
		expectedElements.add(element.left());
		expectedElements.add(element.bottom());
		expectedElements.add(element.top());

		List<Coordinate> elements = finder.findEquals(element);

		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(expectedElements.contains(e));
		}
	}

	@Test
	public void shouldFindFourEqualsAdjacentElements() {
		Coordinate element = new Coordinate(3, 2);

		List<Coordinate> expectedElements = new ArrayList<Coordinate>();
		expectedElements.add(element.left());
		expectedElements.add(element.right());
		expectedElements.add(element.bottom());
		expectedElements.add(element.top());

		List<Coordinate> elements = finder.findEquals(element);

		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(expectedElements.contains(e));
		}
	}
	
}