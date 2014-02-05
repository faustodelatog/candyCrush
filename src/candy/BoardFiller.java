package candy;

import java.util.Random;

public class BoardFiller {

	private Object[][] board;
	
	public BoardFiller(Object[][] board) {
		super();
		this.board = board;
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
