package candy;

public class CandyGame {

	private String[][] board;

	public CandyGame(int i) {
		board = new String[i][i];
	}

	public Object[][] getBoard() {
		return board;
	}

	public void fill(String[] symbols) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = symbols[0];
			}
		}

	}

}
