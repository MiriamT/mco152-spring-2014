package teitelbaum.tictactoe;

import org.junit.Assert;
import org.junit.Test;

public class TicTacToeBoardTest 
{
	@Test
	public void testGetAndSet()
	{
		TicTacToeBoard board = new TicTacToeBoard();
		Symbol s = board.getSquare(new Location(0, 0));
		Assert.assertTrue(s == null);
		board.setSquare(new Location(0, 0), Symbol.X);
		s = board.getSquare(new Location(0, 0));
		Assert.assertTrue(s.equals(Symbol.X));
		board.setSquare(null, null);
		board.getSquare(null);
	}
	
	@Test
	public void testReset()
	{
		TicTacToeBoard board = new TicTacToeBoard();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				board.setSquare(new Location(i, j), Symbol.X);
			}
		}
		board.reset();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				Assert.assertEquals(null, board.getSquare(new Location(i, j)));
			}
		}
	}
	
	@Test
	public void testIsFull()
	{
		TicTacToeBoard board = new TicTacToeBoard();
		for (int i = 0; i < 3; i++)
		{
			Assert.assertFalse(board.isFull());
			for (int j = 0; j < 3; j++)
			{
				board.setSquare(new Location(i, j), Symbol.X);
			}
		}
		Assert.assertTrue(board.isFull());
	}
}
