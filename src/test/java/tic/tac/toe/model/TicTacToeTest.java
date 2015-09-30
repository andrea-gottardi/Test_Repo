package tic.tac.toe.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tic.tac.toe.exception.EndException;
import tic.tac.toe.model.Symbols;
import tic.tac.toe.model.TicTacToe;

/**
 * This class test the TicTacToe one. Verifies that the moves
 * are done in the correct way and that the winner/draw is
 * determined in the right way.
 * 
 * */
public class TicTacToeTest {

	private TicTacToe ticTacToe;

	@Before
	public void init() {
		ticTacToe = new TicTacToe();
	}

	@Test
	public void moveX() throws EndException {
		Boolean move = ticTacToe.move(0, 0, Symbols.X);
		Assert.assertEquals(true, move);
		Assert.assertEquals(Symbols.X, ticTacToe.getBoard()[0][0]);
	}

	@Test
	public void moveO() throws EndException {
		Boolean move = ticTacToe.move(0, 0, Symbols.O);
		Assert.assertEquals(true, move);
		Assert.assertEquals(Symbols.O, ticTacToe.getBoard()[0][0]);
	}

	@Test
	public void wrongMove() throws EndException {
		Boolean move = ticTacToe.move(0, 0, Symbols.O);
		Assert.assertEquals(true, move);
		move = ticTacToe.move(0, 0, Symbols.X);
		Assert.assertEquals(false, move);
	}

	@Test(expected=EndException.class)
	public void draw() throws EndException {
		try {
			Boolean move = ticTacToe.move(0, 0, Symbols.X);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(1, 0, Symbols.O);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(2, 0, Symbols.X);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(0, 1, Symbols.O);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(1, 1, Symbols.O);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(2, 1, Symbols.X);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(0, 2, Symbols.X);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(1, 2, Symbols.X);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(2, 2, Symbols.O);
			Assert.assertEquals(true, move);
		} catch (EndException e) {
			Assert.assertEquals("Game ends with a draw!", e.getMessage());
			throw e;
		}
	}
	
	@Test(expected=EndException.class)
	public void payerXWin() throws EndException {
		try {
			Boolean move = ticTacToe.move(0, 0, Symbols.X);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(1, 0, Symbols.X);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(2, 0, Symbols.X);
			Assert.assertEquals(true, move);
		} catch (EndException e) {
			Assert.assertEquals("Player "+Symbols.X.toString()+" wins!", e.getMessage());
			throw e;
		}
	}
	
	@Test(expected=EndException.class)
	public void payerOWin() throws EndException {
		try {
			Boolean move = ticTacToe.move(0, 2, Symbols.O);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(1, 1, Symbols.O);
			Assert.assertEquals(true, move);
			move = ticTacToe.move(2, 0, Symbols.O);
			Assert.assertEquals(true, move);
		} catch (EndException e) {
			Assert.assertEquals("Player "+Symbols.O.toString()+" wins!", e.getMessage());
			throw e;
		}
	}

}
