package teitelbaum.tictactoe;

public class TicTacToeBoard 
{
	private Symbol[][] board;
	
	public TicTacToeBoard()
	{
		board = new Symbol[3][3];
	}
	
	public void reset()
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				board[i][j] = null;
			}
		}
	}
	
	public boolean isFull()
	{
		for (Symbol[] a : board)
		{
			for (Symbol s : a)
			{
				if (s == null)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void setSquare(Location l, Symbol s) //what should we do if spot is taken?
	{
		if (l!= null && l.getX() >= 0 && l.getX() < 3 && l.getY() >= 0 && l.getY() < 3)
		{
			board[l.getY()][l.getX()] = s;
		}
	}
	
	public Symbol getSquare(Location l)
	{
		if (l != null)
		{
			return board[l.getY()][l.getX()];
		}
		else 
		{
			return null;
		}
	}
	
	public Symbol[][] getBoard()
	{
		return board;
	}
}
