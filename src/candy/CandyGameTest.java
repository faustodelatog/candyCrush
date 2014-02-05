package candy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyGameTest {

	private CandyGame game = null;
	private Object[] symbols = { "A", "B", "C", "D" };
	private Object[][] board = { 
			{ 1, 2, 4, 2, 6, 7, 8, 5, 3 },
			{ 1, 2, 3, 2, 5, 5, 4, 3, 2 },
			{ 1, 2, 2, 2, 2, 2, 2, 6, 3 }, 
			{ 1, 2, 3, 2, 1, 4, 3, 5, 7 },
			{ 1, 1, 3, 2, 8, 8, 6, 5, 3 }, 
			{ 2, 3, 5, 2, 2, 8, 3, 1, 2 },
			{ 4, 3, 2, 2, 7, 8, 7, 3, 1 }, 
			{ 7, 6, 3, 2, 9, 8, 8, 3, 4 },
			{ 2, 4, 5, 6, 6, 7, 7, 2, 1 } };

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
		game.fill(symbols);
		Object[][] board1 = copyMatrix(game.getBoard());

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

	private Object[][] copyMatrix(Object[][] matrix) {
		Object[][] result = new Object[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result[i][j] = matrix[i][j];
			}
		}
		return result;
	}

	@Test
	public void shouldLeftElementIsEqualTo() {
		game.setBoard(board);
		boolean equal = game.isLeftElementEqualTo(new Coordinate(3,2));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldLeftElementIsNotEqualTo() {
		game.setBoard(board);
		boolean equal = game.isLeftElementEqualTo(new Coordinate(1,2));
			
		Assert.assertFalse(equal);
	}

	@Test
	public void shouldRightElementIsEqualTo() {
		game.setBoard(board);
		boolean equal = game.isRightElementEqualTo(new Coordinate(4,4));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldRightElementIsNotEqualTo() {
		game.setBoard(board);
		boolean equal = game.isRightElementEqualTo(new Coordinate(4,5));
			
		Assert.assertFalse(equal);
	}

	@Test
	public void shouldTopElementIsEqualTo() {
		game.setBoard(board);
		boolean equal = game.isTopElementEqualTo(new Coordinate(5,5));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldTopElementIsNotEqualTo() {
		game.setBoard(board);
		boolean equal = game.isTopElementEqualTo(new Coordinate(6,6));
			
		Assert.assertFalse(equal);
	}

	@Test
	public void shouldBottomElementIsEqualTo() {
		game.setBoard(board);
		boolean equal = game.isBottomElementEqualTo(new Coordinate(1,5));
			
		Assert.assertTrue(equal);
	}

	@Test
	public void shouldBottomElementIsNotEqualTo() {
		game.setBoard(board);
		boolean equal = game.isBottomElementEqualTo(new Coordinate(7,7));
			
		Assert.assertFalse(equal);
	}

	@Test
	public void shouldFindThreeEqualsAdjacentElements() {
		game.setBoard(board);
		
		Coordinate element = new Coordinate(3, 6);
		
		List<Coordinate> expectedElements = new ArrayList<Coordinate>();
		expectedElements.add(element.left());
		expectedElements.add(element.bottom());
		expectedElements.add(element.top());
		
		List<Coordinate> elements = game.getEqualAdjacentElements(element);
			
		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(expectedElements.contains(e));
		}
	}

	@Test
	public void shouldFindFourEqualsAdjacentElements() {
		game.setBoard(board);
		
		Coordinate element = new Coordinate(3, 2);
		
		List<Coordinate> expectedElements = new ArrayList<Coordinate>();
		expectedElements.add(element.left());
		expectedElements.add(element.right());
		expectedElements.add(element.bottom());
		expectedElements.add(element.top());
		
		List<Coordinate> elements = game.getEqualAdjacentElements(element);
			
		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(expectedElements.contains(e));
		}
	}
}
