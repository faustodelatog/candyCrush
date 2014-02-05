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
public class ConsecutiveElementFinderTest extends BaseTest {
	
	private ConsecutiveElementFinder finder;
	
	@Before
	public void initTest() {
		finder = new ConsecutiveElementFinder(board);
	}

	@Test
	public void shouldFindAllConsecutivesElements(){
		Coordinate element = new Coordinate(2, 2);

		List<Coordinate> expectedElements = getExpectedConsecutiveEqualElements();
		
		List<Coordinate> elements = finder.findEquals(element);
		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(String.format("El elemento %s no se encuentra en la lista", e), expectedElements.contains(e));
		}
	}

	@Test
	public void shouldFindAllConsecutivesElementsDifferentSeed(){
		Coordinate element = new Coordinate(3, 1);

		List<Coordinate> expectedElements = getExpectedConsecutiveEqualElements();
		
		List<Coordinate> elements = finder.findEquals(element);
		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(String.format("El elemento %s no se encuentra en la lista", e), expectedElements.contains(e));
		}
	}

	private List<Coordinate> getExpectedConsecutiveEqualElements(){
		List<Coordinate> result = new ArrayList<Coordinate>();
		result.add(new Coordinate(1,0));
		result.add(new Coordinate(1,1));
		result.add(new Coordinate(1,2));
		result.add(new Coordinate(1,3));
		result.add(new Coordinate(2,2));
		result.add(new Coordinate(2,6));
		result.add(new Coordinate(3,0));
		result.add(new Coordinate(3,1));
		result.add(new Coordinate(3,2));
		result.add(new Coordinate(3,3));
		result.add(new Coordinate(3,4));
		result.add(new Coordinate(3,5));
		result.add(new Coordinate(3,6));
		result.add(new Coordinate(3,7));
		result.add(new Coordinate(4,2));
		result.add(new Coordinate(4,5));
		result.add(new Coordinate(5,2));
		result.add(new Coordinate(6,2));
		
		return result;
	}
}
