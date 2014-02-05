package candy;

public class ElementComparator {
	
	private Object[][] board;

	public ElementComparator(Object[][] board) {
		this.board = board;
	}
	
	private boolean areElementsEqual(Coordinate origin, Coordinate target){
		if(!target.isValid(board.length)){
			return false;
		}
		
		return board[origin.getY()][origin.getX()].equals(board[target.getY()][target.getX()]);
	}
	
	public boolean isLeftElementEqualTo(Coordinate coordinate) {		
		return areElementsEqual(coordinate, coordinate.left());
	}

	public boolean isRightElementEqualTo(Coordinate coordinate) {
		return areElementsEqual(coordinate, coordinate.right());
	}

	public boolean isTopElementEqualTo(Coordinate coordinate) {
		return areElementsEqual(coordinate, coordinate.top());
	}

	public boolean isBottomElementEqualTo(Coordinate coordinate) {
		return areElementsEqual(coordinate, coordinate.bottom());
	}

}
