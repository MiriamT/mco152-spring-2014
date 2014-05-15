package teitelbaum.tictactoe;

public class Location implements Comparable<Location>
{
	int x;
	int y;
	
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int compareTo(Location l)
	{
		if (x == l.x && y == l.y)
		{
			return 0;
		}
		else if (y < l.y)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	public boolean equals(Object o)
	{
		if (o instanceof Location)
		{
			Location l = (Location)o;
			return (x == l.x && y == l.y);
		}
		else
		{
			return false;
		}
	}
}
