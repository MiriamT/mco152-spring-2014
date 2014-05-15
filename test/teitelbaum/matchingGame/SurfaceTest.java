package teitelbaum.matchingGame;

import org.junit.Assert;
import org.junit.Test;

public class SurfaceTest
{
	@Test
	public void testConstructor()
	{
		int numPairs = 4;
		Surface s = new Surface(numPairs);
		int matches = 0;
		for (int i = 0; i < numPairs; i++)
		{
			if (s.getCardPair(i).size() == 2)
			{
				matches++;
			}
		}
		Assert.assertEquals(numPairs, matches);
	}

	@Test
	public void testReset()
	{
		Surface s = new Surface(4);
		Assert.assertFalse(s.getCards().get(0).isFaceUp());
		Assert.assertFalse(s.getCards().get(7).isMatched());

		for (Card c : s.getCards())
		{
			c.flip();
			c.match();
		}
		Assert.assertTrue(s.getCards().get(0).isFaceUp());
		Assert.assertTrue(s.getCards().get(7).isMatched());

		s.reset();
		Assert.assertFalse(s.getCards().get(0).isFaceUp());
		Assert.assertFalse(s.getCards().get(7).isMatched());
	}

	@Test
	public void testIsEmpty()
	{
		Surface s = new Surface(4);
		Assert.assertFalse(s.isEmpty());
		for (Card c : s.getCards())
		{
			c.match();
		}
		Assert.assertTrue(s.isEmpty());
	}
}
