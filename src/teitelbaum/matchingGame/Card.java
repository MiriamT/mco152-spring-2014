package teitelbaum.matchingGame;

public class Card
{
	private final int id;
	private boolean faceUp;
	private boolean matched;

	public Card(int id)
	{
		this.id = id;
		faceUp = false;
		matched = false;
	}

	public int getId()
	{
		return id;
	}

	public boolean isFaceUp()
	{
		return faceUp;
	}

	public boolean isMatched()
	{
		return matched;
	}

	public void flip()
	{
		faceUp = !faceUp;
	}

	public void match()
	{
		matched = true;
	}

	public void reset()
	{
		faceUp = false;
		matched = false;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Card other = (Card) obj;
		if (id != other.id)
		{
			return false;
		}
		return true;
	}
}
