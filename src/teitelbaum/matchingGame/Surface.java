package teitelbaum.matchingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Surface
{
	private final List<Card> cards;

	public Surface(int numCardPairs)
	{
		cards = new ArrayList<Card>();
		for (int i = 0; i < numCardPairs; i++)
		{
			cards.add(new Card(i)); //add a pair
			cards.add(new Card(i));
		}
		Collections.shuffle(cards);
	}

	//	public void flip(Card card) //or can send in cardID? - well i think image tag will be card..
	//but maybe will find wrong card since both have same id..
	//	{
	//		for (Card c : cards)
	//		{
	//			if (c.equals(card))
	//			{
	//				c.flip();
	//				return;
	//			}
	//		}
	//	}

	public void reset()
	{
		for (Card c : cards)
		{
			c.reset();
		}
		Collections.shuffle(cards);
	}

	public Card getCard(int cardID)
	{
		for (Card c : cards)
		{
			if (c.getId() == cardID)
			{
				return c;
			}
		}
		return null;
	}

	public List<Card> getCards()
	{
		return cards;
	}

	public List<Card> getCardPair(int cardID)
	{
		ArrayList<Card> pair = new ArrayList<Card>();
		for (Card c : cards)
		{
			if (c.getId() == cardID)
			{
				pair.add(c);
			}
		}
		return pair;
	}

	public boolean isEmpty()
	{
		for (Card c : cards)
		{
			if (!c.isMatched())
			{
				return false;
			}
		}
		return true;
	}

}
