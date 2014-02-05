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

	public void setBoard(Object[][] board) {
		this.board = board;
	}

	public boolean isLeftElementEqualTo(Coordinate coordinate) {
		if(coordinate.getX() == 0){
			return false;
		}
		Object origin = board[coordinate.getY()][coordinate.getX()];
		Object target = board[coordinate.getY()][coordinate.getX() - 1];
		return origin.equals(target);
	}

	public boolean isRightElementEqualTo(Coordinate coordinate) {
		if(coordinate.getX() == board.length - 1){
			return false;
		}
		Object origin = board[coordinate.getY()][coordinate.getX()];
		Object target = board[coordinate.getY()][coordinate.getX() + 1];
		return origin.equals(target);
	}

	public boolean isTopElementEqualTo(Coordinate coordinate) {
		if(coordinate.getY() == 0){
			return false;
		}
		Object origin = board[coordinate.getY()][coordinate.getX()];
		Object target = board[coordinate.getY() - 1][coordinate.getX()];
		return origin.equals(target);
	}

	public boolean isBottomElementEqualTo(Coordinate coordinate) {
		if(coordinate.getY() == board.length - 1){
			return false;
		}
		Object origin = board[coordinate.getY()][coordinate.getX()];
		Object target = board[coordinate.getY() + 1][coordinate.getX()];
		return origin.equals(target);
	}

}
