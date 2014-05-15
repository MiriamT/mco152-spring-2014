package teitelbaum.weather;

public class Coord
{
	private double lon;
	private double lat;

	public double getLon()
	{
		return lon;
	}

	public double getLat()
	{
		return lat;
	}

	@Override
	public String toString()
	{
		return "\nCoord: " + lon + ", " + lat;
	}

}
