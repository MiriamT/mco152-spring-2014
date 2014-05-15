package teitelbaum.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Evaluator 
{
	private TicTacToeBoard board;
	private Symbol winner;
	private ArrayList<Location> winningSquares; 
	
	public Evaluator(TicTacToeBoard t)
	{
		board = t;
		winner = null;
		winningSquares = new ArrayList<Location>();
	}
	
	public void evaluate()
	{
		if (board != null)
		{
			if (!winningSquares.isEmpty())
			{
				winningSquares = new ArrayList<Location>();
			}
			
			if(checkAcross())
			{
				return;
			}
			else if(checkDown())
			{
				return;
			}
			else
			{
				checkDiag();
			}
		}
	}
	
	private boolean checkAcross()
	{
		for (int i = 0; i < board.getBoard().length; i++)
		{
			Symbol same = board.getBoard()[i][0];
			if (same != null && board.getBoard()[i][1] != null && board.getBoard()[i][2] != null && board.getBoard()[i][1].equals(same) && board.getBoard()[i][2].equals(same))
			{
				winner = same;
				winningSquares.add(new Location(0, i));
				winningSquares.add(new Location(1, i));
				winningSquares.add(new Location(2, i));
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDown()
	{
		for (int i = 0; i < board.getBoard()[0].length; i++)
		{
			Symbol same = board.getBoard()[0][i];
			if (same != null && board.getBoard()[1][i] != null && board.getBoard()[2][i] != null && board.getBoard()[1][i].equals(same) && board.getBoard()[2][i].equals(same))
			{
				winner = same;
				winningSquares.add(new Location(i, 0));
				winningSquares.add(new Location(i, 1));
				winningSquares.add(new Location(i, 2));
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDiag()
	{
		if (board.getBoard()[0][0] != null && board.getBoard()[1][1] != null && board.getBoard()[2][2] != null && board.getBoard()[0][0].equals(board.getBoard()[1][1]) && board.getBoard()[0][0].equals(board.getBoard()[2][2]))
		{
			winner = board.getBoard()[0][0];
			winningSquares.add(new Location(0, 0));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 2));
			return true;
		}
		else if (board.getBoard()[2][0] != null && board.getBoard()[1][1]!= null && board.getBoard()[0][2]!= null && board.getBoard()[2][0].equals(board.getBoard()[1][1]) && board.getBoard()[2][0].equals(board.getBoard()[0][2]))
		{
			winner = board.getBoard()[2][0];
			winningSquares.add(new Location(0, 2));
			winningSquares.add(new Location(1, 1));
			winningSquares.add(new Location(2, 0));
			return true;
		}
		return false;
	}
	
	public Symbol getWinner()
	{
		return winner;
	}
	
	public List<Location> getWinningSquares()
	{
		if (winningSquares.isEmpty())
		{
			return null;
		}
		else
		{
			return winningSquares;
		}
	}
}
