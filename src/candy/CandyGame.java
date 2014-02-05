package candy;


public class CandyGame {

	private Object[][] board;
	private BoardFiller filler;
	private ConsecutiveElementFinder finder;

	public CandyGame(int i) {
		this(new Object[i][i]);
	}
	
	public CandyGame(Object[][] board) {
		this.board = board;
		filler = new BoardFiller(board);
		finder = new ConsecutiveElementFinder(board);
	}

	public void fill(Object[] symbols) {
		filler.fill(symbols);
	}

	// Solo por test tiene razon este metodo
	public Object[][] getBoard() {
		return board;
	}
}
