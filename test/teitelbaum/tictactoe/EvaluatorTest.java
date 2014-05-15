package teitelbaum.tictactoe;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest 
{
	@Test
	public void testEvaluate()
	{
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);
		eval.evaluate();
		Assert.assertEquals(null, eval.getWinner());
		
		for (int i = 0; i < 3; i++)
		{
			board.setSquare(new Location(0, i), Symbol.X);
		}
		eval.evaluate();
		Assert.assertEquals(Symbol.X, eval.getWinner());
		
		board.reset();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				board.setSquare(new Location(i, j), Symbol.X);
			}
		}
		eval.evaluate();
		Assert.assertEquals(Symbol.X, eval.getWinner());
		
		board.reset();
		for (int i = 0; i < 3; i++)
		{
			board.setSquare(new Location(i, 0), Symbol.O);
		}
		eval.evaluate();
		Assert.assertEquals(Symbol.O, eval.getWinner());
		
		eval = new Evaluator(null);
		eval.evaluate();
		Assert.assertEquals(null, eval.getWinner());
		Assert.assertEquals(null, eval.getWinningSquares());
	}
	
	@Test
	public void testWinningSquares()
	{
		TicTacToeBoard board = new TicTacToeBoard();
		Evaluator eval = new Evaluator(board);
		eval.evaluate();
		Assert.assertEquals(null, eval.getWinningSquares());
		
		ArrayList<Location> expected = new ArrayList<Location>();
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				board.setSquare(new Location(i, j), Symbol.X);
			}
		}
		eval.evaluate();
		expected.add(new Location(0, 0));
		expected.add(new Location(1, 0));
		expected.add(new Location(2, 0));
		Assert.assertEquals(expected, eval.getWinningSquares());
		
		board.reset();
		eval.evaluate();
		Assert.assertEquals(null, eval.getWinningSquares());
		
		board.setSquare(new Location(0, 2), Symbol.O);
		board.setSquare(new Location(1, 1), Symbol.O);
		board.setSquare(new Location(2, 0), Symbol.O);
		eval.evaluate();
		expected = new ArrayList<Location>();
		expected.add(new Location(0, 2));
		expected.add(new Location(1, 1));
		expected.add(new Location(2, 0));
		Assert.assertEquals(expected, eval.getWinningSquares());
	}
}
