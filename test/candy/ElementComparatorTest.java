package candy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElementComparatorTest extends BaseTest {

	private ElementComparator comparator;

	@Before
	public void initTest() {
		comparator = new ElementComparator(board);
	}


	@Test
	public void shouldLeftElementIsEqualTo() {
		boolean equal = comparator.isLeftElementEqualTo(new Coordinate(3,2));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldLeftElementIsNotEqualTo() {
		boolean equal = comparator.isLeftElementEqualTo(new Coordinate(1,2));
			
		Assert.assertFalse(equal);
	}

	@Test
	public void shouldRightElementIsEqualTo() {
		boolean equal = comparator.isRightElementEqualTo(new Coordinate(4,4));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldRightElementIsNotEqualTo() {
		boolean equal = comparator.isRightElementEqualTo(new Coordinate(4,5));
			
		Assert.assertFalse(equal);
	}

	@Test
	public void shouldTopElementIsEqualTo() {
		boolean equal = comparator.isTopElementEqualTo(new Coordinate(5,5));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldTopElementIsNotEqualTo() {
		boolean equal = comparator.isTopElementEqualTo(new Coordinate(6,6));
			
		Assert.assertFalse(equal);
	}

	@Test
	public void shouldBottomElementIsEqualTo() {
		boolean equal = comparator.isBottomElementEqualTo(new Coordinate(1,5));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldBottomElementIsNotEqualTo() {
		boolean equal = comparator.isBottomElementEqualTo(new Coordinate(7,7));
			
		Assert.assertFalse(equal);
	}
}
