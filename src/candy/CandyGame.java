package candy;

import java.util.ArrayList;
import java.util.List;

public class CandyGame {

	private Object[][] board;
	private ElementComparator comparator;
	private BoardFiller filler;

	public CandyGame(int i) {
		this(new Object[i][i]);
	}
	
	public CandyGame(Object[][] board) {
		this.board = board;
		comparator = new ElementComparator(board);
		filler = new BoardFiller(board);
	}

	public void fill(Object[] symbols) {
		filler.fill(symbols);
	}

	// Solo por test tiene razon este metodo
	public Object[][] getBoard() {
		return board;
	}
	
	public List<Coordinate> getEqualAdjacentElements(Coordinate coordinate) {
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

	public List<Coordinate> getAllConsecutiveEqualElements(Coordinate element) {
		List<Coordinate> result = new ArrayList<Coordinate>();
		setElements(result, element);
		return result;
	}
	
	private void setElements(List<Coordinate> elements, Coordinate origin){
		if(elements.contains(origin)){
			return;
		}
		elements.add(origin);
		List<Coordinate> equalAdjacents = getEqualAdjacentElements(origin);
		for (Coordinate adjacent : equalAdjacents) {
			setElements(elements, adjacent);
		}
		
	}

}
