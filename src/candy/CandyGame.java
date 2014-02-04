package candy;

import java.util.Random;

public class CandyGame {

	private Object[][] board;

	public CandyGame(int i) {
		board = new String[i][i];
	}

	public Object[][] getBoard() {
		return board;
	}

	public void fill(Object[] symbols) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = symbols[getRandom(0, symbols.length)];
			}
		}
	}

	private int getRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max) + min;
	}

}
