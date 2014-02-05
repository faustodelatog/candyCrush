package candy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardFillerTest extends BaseTest {
	
	private BoardFiller filler = null;
	private Object[][] board = new Object[10][10];
	private Object[] symbols = { "A", "B", "C", "D" };

	@Before
	public void initTest() {
		filler = new BoardFiller(board);
	}

	@Test
	public void shouldFillBoardWithSymbols() {
		Object[] symbols = { "A", "B", "C", "D" };
		filler.fill(symbols);
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
		filler.fill(symbols);
		Object[][] board1 = copyMatrix(board);

		filler.fill(symbols);
		Object[][] board2 = board;

		boolean isRandom = false;
		for (int i = 0; i < board.length; i++) {
			isRandom = false;
			for (int j = 0; j < board.length; j++) {
				if (board2[i][j] != board1[i][j]) {
					isRandom = true;
					break;
				}
				if (j >= board.length)
					Assert.fail(String
							.format("No existe ningun elemento diferente en la fila %s",
									i));
			}
		}

		Assert.assertTrue(isRandom);
	}

	private Object[][] copyMatrix(Object[][] matrix) {
		Object[][] result = new Object[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result[i][j] = matrix[i][j];
			}
		}
		return result;
	}

}
