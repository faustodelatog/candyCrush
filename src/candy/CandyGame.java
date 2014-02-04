package candy;

public class CandyGame {

	private int boardDimension;

	public CandyGame(int i) {
		boardDimension = i;
	}

	public Object[][] getBoard() {
		return new Object[boardDimension][boardDimension];
	}

}
