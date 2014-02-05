package candy;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveElementFinder {
	
	private AdjacentElementFinder adjacentFinder;

	public ConsecutiveElementFinder(Object[][] board) {
		this.adjacentFinder = new AdjacentElementFinder(board);
	}

	public List<Coordinate> findEquals(Coordinate element) {
		List<Coordinate> result = new ArrayList<Coordinate>();
		setElements(result, element);
		return result;
	}
	
	private void setElements(List<Coordinate> elements, Coordinate origin){
		if(elements.contains(origin)){
			return;
		}
		elements.add(origin);
		List<Coordinate> equalAdjacents = adjacentFinder.findEquals(origin);
		for (Coordinate adjacent : equalAdjacents) {
			setElements(elements, adjacent);
		}
		
	}
}
