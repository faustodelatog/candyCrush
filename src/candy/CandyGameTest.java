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
		String[] symbols = { "A", "B", "C", "D" };
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

}
