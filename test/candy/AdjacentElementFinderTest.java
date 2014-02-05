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
public class AdjacentElementFinderTest extends BaseTest {
	
	private AdjacentElementFinder finder;

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
