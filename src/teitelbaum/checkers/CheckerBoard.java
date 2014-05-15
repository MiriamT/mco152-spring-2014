package teitelbaum.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard
{

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard()
	{
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y)
	{
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece)
	{
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y)
	{
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y)
	{
		return x >= 0 && y >= 0 && x < HEIGHT && y < WIDTH;
	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y)
	{
		return this.getPiece(x, y) == null;
	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear()
	{
		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				removePiece(x, y);
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame()
	{
		clear();
		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = y % 2 == 0 ? 1 : 0; x < WIDTH; x += 2)
			{
				if (y < 3)
				{
					this.setPiece(x, y, Piece.WHITE_MAN);
				}
				else if (y > 4)
				{
					this.setPiece(x, y, Piece.RED_MAN);
				}
			}
		}
	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for (Piece[] a : board)
		{
			for (Piece p : a)
			{
				if (p == null)
				{
					s.append("-");
				}
				else
				{
					s.append(p.toString());
				}
			}
			s.append("\n");
		}
		return s.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move)
	{
		Piece p = getPiece(move.getX1(), move.getY1());
		this.removePiece(move.getX1(), move.getY1());
		if (p.getColor().equals(Color.WHITE))
		{
			if (move.getY2() == 7)
			{
				p = Piece.WHITE_KING;
			}
		}
		else
		{
			if (move.getY2() == 0)
			{
				p = Piece.RED_KING;
			}
		}
		this.setPiece(move.getX2(), move.getY2(), p);
	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump)
	{
		Piece p = getPiece(jump.getX1(), jump.getY1());
		this.removePiece(jump.getX1(), jump.getY1());
		if (p.getColor().equals(Color.WHITE))
		{
			if (jump.getY2() == 7)
			{
				p = Piece.WHITE_KING;
			}
		}
		else
		{
			if (jump.getY2() == 0)
			{
				p = Piece.RED_KING;
			}
		}
		this.setPiece(jump.getX2(), jump.getY2(), p);
		this.removePiece(jump.getCaptureX(), jump.getCaptureY());
	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y)
	{
		Piece p = getPiece(x, y);
		ArrayList<Move> moves = new ArrayList<Move>();
		if (p != null)
		{
			if (p.isKing() || p.getColor().equals(Color.RED)) //red goes up
			{
				if (this.isOnBoard(x - 1, y - 1) && getPiece(x - 1, y - 1) == null)
				{
					moves.add(new Move(x, y, x - 1, y - 1));
				}
				if (isOnBoard(x + 1, y - 1) && getPiece(x + 1, y - 1) == null)
				{
					moves.add(new Move(x, y, x + 1, y - 1));
				}
			}
			if (p.isKing() || p.getColor().equals(Color.WHITE)) //white goes down
			{
				if (isOnBoard(x - 1, y + 1) && getPiece(x - 1, y + 1) == null)
				{
					moves.add(new Move(x, y, x - 1, y + 1));
				}
				if (isOnBoard(x + 1, y + 1) && getPiece(x + 1, y + 1) == null)
				{
					moves.add(new Move(x, y, x + 1, y + 1));
				}
			}
		}
		return moves;
	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y)
	{
		Piece p = getPiece(x, y);
		Piece jumped = null;
		ArrayList<Jump> jumps = new ArrayList<Jump>();
		if (p != null)
		{
			if (p.isKing() || p.getColor().equals(Color.RED))
			{
				jumped = getPiece(x - 1, y - 1);
				if (isOnBoard(x - 2, y - 2) && getPiece(x - 2, y - 2) == null && jumped != null && !jumped.isSameColor(p))
				{
					jumps.add(new Jump(x, y, x - 1, y - 1, x - 2, y - 2));
				}

				jumped = getPiece(x + 1, y - 1);
				if (isOnBoard(x + 2, y - 2) && getPiece(x + 2, y - 2) == null && jumped != null && !jumped.isSameColor(p))
				{
					jumps.add(new Jump(x, y, x + 1, y - 1, x + 2, y - 2));
				}
			}
			if (p.isKing() || p.getColor().equals(Color.WHITE))
			{
				jumped = getPiece(x - 1, y + 1);
				if (isOnBoard(x - 2, y + 2) && getPiece(x - 2, y + 2) == null && jumped != null && !jumped.isSameColor(p))
				{
					jumps.add(new Jump(x, y, x - 1, y + 1, x - 2, y + 2));
				}
				jumped = getPiece(x + 1, y + 1);
				if (isOnBoard(x + 2, y + 2) && getPiece(x + 2, y + 2) == null && jumped != null && !jumped.isSameColor(p))
				{
					jumps.add(new Jump(x, y, x + 1, y + 1, x + 2, y + 2));
				}
			}
		}
		return jumps;
	}
}
