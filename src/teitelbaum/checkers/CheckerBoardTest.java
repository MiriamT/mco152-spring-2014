package teitelbaum.checkers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest
{

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard()
	{
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n" + "--------\n" + "--------\n" + "--------\n" + "--------\n" + "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame()
	{
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n" + "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n" + "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard()
	{
		CheckerBoard board = new CheckerBoard();
		Assert.assertTrue(board.isOnBoard(0, 0));
		Assert.assertTrue(board.isOnBoard(3, 5));
		Assert.assertTrue(board.isOnBoard(7, 7));
		Assert.assertFalse(board.isOnBoard(0, 8));
		Assert.assertFalse(board.isOnBoard(8, 0));
		Assert.assertFalse(board.isOnBoard(8, 8));
		Assert.assertFalse(board.isOnBoard(-1, -1));
	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare()
	{
		CheckerBoard board = new CheckerBoard();
		Assert.assertTrue(board.isEmptySquare(0, 0));
		board.setPiece(0, 0, Piece.WHITE_KING);
		Assert.assertFalse(board.isEmptySquare(0, 0));
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear()
	{
		CheckerBoard board = new CheckerBoard();
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				board.setPiece(i, j, Piece.WHITE_MAN);
			}
		}

		board.clear();
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				Assert.assertNull(board.getPiece(i, j));
			}
		}
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame()
	{
		CheckerBoard board = new CheckerBoard();

		for (int y = 0; y < 8; y++) //fill the board with pieces
		{
			for (int x = y % 2 == 0 ? 1 : 0; x < 8; x += 2)
			{
				if (y % 2 == 0)
				{
					board.setPiece(x, y, Piece.WHITE_MAN);
				}
				else
				{
					board.setPiece(x, y, Piece.RED_MAN);
				}
			}
		}

		board.resetNewGame();

		for (int y = 0; y < 3; y++) //check red section
		{
			for (int x = y % 2 == 0 ? 0 : 1; x < 8; x += 2)
			{
				Assert.assertNull(board.getPiece(x, y));
			}
			for (int x = y % 2 == 0 ? 1 : 0; x < 8; x += 2)
			{
				Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(x, y));
			}
		}

		for (int y = 3; y < 5; y++) //check middle part
		{
			for (int x = 0; x < 8; x++)
			{
				Assert.assertNull(board.getPiece(x, y));
			}
		}

		for (int y = 5; y < 8; y++) //check white section
		{
			for (int x = y % 2 == 0 ? 0 : 1; x < 8; x += 2)
			{
				Assert.assertNull(board.getPiece(x, y));
			}
			for (int x = y % 2 == 0 ? 1 : 0; x < 8; x += 2)
			{
				Assert.assertEquals(Piece.RED_MAN, board.getPiece(x, y));
			}
		}
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 0, Piece.WHITE_MAN);
		Move move = new Move(0, 0, 1, 1);
		board.execute(move);
		Assert.assertNull(board.getPiece(0, 0));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(1, 1));
	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 6, Piece.WHITE_MAN);
		Move move = new Move(1, 6, 0, 7);
		board.execute(move);
		Assert.assertEquals(Piece.WHITE_KING, board.getPiece(0, 7));
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 1, Piece.RED_MAN);
		Move move = new Move(0, 1, 1, 0);
		board.execute(move);
		Assert.assertEquals(Piece.RED_KING, board.getPiece(1, 0));
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 0, Piece.WHITE_MAN);
		board.setPiece(1, 1, Piece.RED_MAN);
		Jump jump = new Jump(0, 0, 1, 1, 2, 2);
		board.execute(jump);

		Assert.assertNull(board.getPiece(0, 0));
		Assert.assertNull(board.getPiece(1, 1));
		Assert.assertEquals(Piece.WHITE_MAN, board.getPiece(2, 2));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(1, 1, Piece.WHITE_MAN);
		board.setPiece(2, 2, Piece.RED_MAN);
		Jump jump = new Jump(2, 2, 1, 1, 0, 0);
		board.execute(jump);

		Assert.assertNull(board.getPiece(2, 2));
		Assert.assertNull(board.getPiece(1, 1));
		Assert.assertEquals(Piece.RED_KING, board.getPiece(0, 0));
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.WHITE_MAN);
		board.setPiece(6, 6, Piece.RED_MAN);
		Jump jump = new Jump(5, 5, 6, 6, 7, 7);
		board.execute(jump);

		Assert.assertNull(board.getPiece(5, 5));
		Assert.assertNull(board.getPiece(6, 6));
		Assert.assertEquals(Piece.WHITE_KING, board.getPiece(7, 7));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare()
	{
		CheckerBoard board = new CheckerBoard();
		Assert.assertEquals(0, board.getMoves(0, 0).size());
		Assert.assertEquals(0, board.getMoves(5, 5).size());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_MAN);
		List<Move> moves = board.getMoves(5, 5);
		Assert.assertEquals(2, moves.size());
		Assert.assertTrue(moves.contains(new Move(5, 5, 4, 4)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 6, 4)));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_KING);
		List<Move> moves = board.getMoves(5, 5);
		Assert.assertEquals(4, moves.size());
		Assert.assertTrue(moves.contains(new Move(5, 5, 4, 4)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 6, 4)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 4, 6)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 6, 6)));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.WHITE_MAN);
		List<Move> moves = board.getMoves(5, 5);
		Assert.assertEquals(2, moves.size());
		Assert.assertTrue(moves.contains(new Move(5, 5, 4, 6)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 6, 6)));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.WHITE_KING);
		List<Move> moves = board.getMoves(5, 5);
		Assert.assertEquals(4, moves.size());
		Assert.assertTrue(moves.contains(new Move(5, 5, 4, 4)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 6, 4)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 4, 6)));
		Assert.assertTrue(moves.contains(new Move(5, 5, 6, 6)));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_KING);
		board.setPiece(4, 4, Piece.WHITE_MAN);
		board.setPiece(6, 4, Piece.WHITE_MAN);
		board.setPiece(4, 6, Piece.WHITE_MAN);
		board.setPiece(6, 6, Piece.WHITE_MAN);
		List<Move> moves = board.getMoves(5, 5);
		Assert.assertEquals(0, moves.size());
		Assert.assertEquals(new ArrayList<Move>(), moves);
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> moves = board.getMoves(0, 7);
		Assert.assertEquals(1, moves.size());
		Assert.assertTrue(moves.contains(new Move(0, 7, 1, 6)));
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> moves = board.getMoves(7, 0);
		Assert.assertEquals(1, moves.size());
		Assert.assertTrue(moves.contains(new Move(7, 0, 6, 1)));
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare()
	{
		CheckerBoard board = new CheckerBoard();
		Assert.assertEquals(0, board.getJumps(0, 0).size());
		Assert.assertEquals(0, board.getJumps(5, 5).size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_KING);
		Assert.assertEquals(0, board.getJumps(5, 5).size());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_KING);
		board.setPiece(4, 4, Piece.WHITE_MAN);
		board.setPiece(6, 4, Piece.WHITE_MAN);
		board.setPiece(4, 6, Piece.WHITE_MAN);
		board.setPiece(6, 6, Piece.WHITE_MAN);
		List<Jump> jumps = board.getJumps(5, 5);
		Assert.assertEquals(4, jumps.size());
		Assert.assertTrue(jumps.contains(new Jump(5, 5, 4, 4, 3, 3)));
		Assert.assertTrue(jumps.contains(new Jump(5, 5, 6, 4, 7, 3)));
		Assert.assertTrue(jumps.contains(new Jump(5, 5, 4, 6, 3, 7)));
		Assert.assertTrue(jumps.contains(new Jump(5, 5, 6, 6, 7, 7)));
	}

	@Test
	public void testPieceCannotJumpSameColor()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_KING);
		board.setPiece(4, 4, Piece.RED_MAN);
		board.setPiece(6, 4, Piece.RED_MAN);
		board.setPiece(4, 6, Piece.RED_MAN);
		board.setPiece(6, 6, Piece.RED_MAN);
		List<Jump> jumps = board.getJumps(5, 5);
		Assert.assertEquals(0, jumps.size());
	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded()
	{
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 5, Piece.RED_MAN);
		board.setPiece(4, 4, Piece.WHITE_MAN);
		board.setPiece(6, 4, Piece.WHITE_MAN);
		board.setPiece(4, 6, Piece.WHITE_MAN);
		board.setPiece(6, 6, Piece.WHITE_MAN);
		List<Jump> jumps = board.getJumps(5, 5);
		Assert.assertEquals(2, jumps.size());
		Assert.assertTrue(jumps.contains(new Jump(5, 5, 4, 4, 3, 3)));
		Assert.assertTrue(jumps.contains(new Jump(5, 5, 6, 4, 7, 3)));
	}
}
