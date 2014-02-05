package candy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandyGameTest {

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
	public void shouldFindThreeEqualsAdjacentElements() {
		CandyGame game = new CandyGame(board);
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
		CandyGame game = new CandyGame(board);
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

	@Test
	public void shouldFindAllConsecutivesElements(){
		CandyGame game = new CandyGame(board);
		Coordinate element = new Coordinate(2, 2);

		List<Coordinate> expectedElements = getExpectedConsecutiveEqualElements();
		
		List<Coordinate> elements = game.getAllConsecutiveEqualElements(element);
		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(String.format("El elemento %s no se encuentra en la lista", e), expectedElements.contains(e));
		}
	}

	@Test
	public void shouldFindAllConsecutivesElementsDifferentSeed(){
		CandyGame game = new CandyGame(board);
		Coordinate element = new Coordinate(3, 1);

		List<Coordinate> expectedElements = getExpectedConsecutiveEqualElements();
		
		List<Coordinate> elements = game.getAllConsecutiveEqualElements(element);
		Assert.assertEquals(expectedElements.size(), elements.size());
		for (Coordinate e : elements) {
			Assert.assertTrue(String.format("El elemento %s no se encuentra en la lista", e), expectedElements.contains(e));
		}
	}

	private List<Coordinate> getExpectedConsecutiveEqualElements(){
		List<Coordinate> result = new ArrayList<Coordinate>();
		result.add(new Coordinate(1,0));
		result.add(new Coordinate(1,1));
		result.add(new Coordinate(1,2));
		result.add(new Coordinate(1,3));
		result.add(new Coordinate(2,2));
		result.add(new Coordinate(2,6));
		result.add(new Coordinate(3,0));
		result.add(new Coordinate(3,1));
		result.add(new Coordinate(3,2));
		result.add(new Coordinate(3,3));
		result.add(new Coordinate(3,4));
		result.add(new Coordinate(3,5));
		result.add(new Coordinate(3,6));
		result.add(new Coordinate(3,7));
		result.add(new Coordinate(4,2));
		result.add(new Coordinate(4,5));
		result.add(new Coordinate(5,2));
		result.add(new Coordinate(6,2));
		
		return result;
	}




}
