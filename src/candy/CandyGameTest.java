package candy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyGameTest {

	private CandyGame game = null;

	@Before
	public void initTest() {
		game = new CandyGame(9);
	}

	@Test
	public void shouldConstructAGameWith9x9Board() {
		CandyGame game = new CandyGame(9);
		Object[][] board = game.getBoard();
		Assert.assertEquals(9, board.length);
		for (Object[] row : board) {
			Assert.assertEquals(9, row.length);
		}
	}

	@Test
	public void shouldConstructAGameWith10x10Board() {
		CandyGame game = new CandyGame(10);
		Object[][] board = game.getBoard();
		Assert.assertEquals(10, board.length);
		for (Object[] row : board) {
			Assert.assertEquals(10, row.length);
		}
	}

	@Test
	public void shouldFillBoardWithSymbols() {
		Object[] symbols = { "A", "B", "C", "D" };
		game.fill(symbols);
		Object[][] board = game.getBoard();
		for (Object[] row : board) {
			for (Object e : row) {
				Assert.assertTrue(isInArray(symbols, e));
			}
		}
	}

	private boolean isInArray(Object[] array, Object e) {
		for (Object element : array) {
			if (element.equals(e)) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void shouldFillBoardWithSymbolsRandom() {
		Object[] symbols = { "A", "B", "C", "D" };
		game.fill(symbols);
		Object[][] board1 = copyMatrix(game.getBoard(), 9);
		game.fill(symbols);
		Object[][] board2 = game.getBoard();

		boolean isRandom = false;
		for (int i = 0; i < 9; i++) {
			isRandom = false;
			for (int j = 0; j < 9; j++) {
				if (board2[i][j] != board1[i][j]) {
					isRandom = true;
					break;
				}
				if (j == 8)
					Assert.fail(String
							.format("No existe ningun elemento diferente en la fila %s",
									i));
			}
		}

		Assert.assertTrue(isRandom);
	}

	private Object[][] copyMatrix(Object[][] matrix, int d) {
		Object[][] result = new Object[d][d];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result[i][j] = matrix[i][j];
			}
		}
		return result;
	}

}
