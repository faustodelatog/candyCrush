package candy;

import java.util.ArrayList;
import java.util.List;

public class AdjacentElementFinder {
	
	private ElementComparator comparator;

	public AdjacentElementFinder(Object[][] board) {
		comparator = new ElementComparator(board);
	}

	public List<Coordinate> findEquals(Coordinate coordinate) {
		List<Coordinate> elements = new ArrayList<Coordinate>();
		if(comparator.isLeftElementEqualTo(coordinate)){
			elements.add(coordinate.left());
		}
		if(comparator.isRightElementEqualTo(coordinate)){
			elements.add(coordinate.right());
		}
		if(comparator.isTopElementEqualTo(coordinate)){
			elements.add(coordinate.top());
		}
		if(comparator.isBottomElementEqualTo(coordinate)){
			elements.add(coordinate.bottom());
		}
		return elements;
	}
}
