package teitelbaum.weather;

public class Wind
{
	private double speed;
	private double gust;
	private double deg;

	public double getSpeed()
	{
		return speed;
	}

	public double getGust()
	{
		return gust;
	}

	public double getDeg()
	{
		return deg;
	}

	@Override
	public String toString()
	{
		return "\nWind speed: " + speed + ", gust: " + gust + ", deg: " + deg;
	}
}
