package teitelbaum.ufo;

public class City
{
	private final String zip;
	private final Double lat;
	private final Double lon;
	private final String name;
	private final String state;

	public City(String zip, Double lat, Double lon, String name, String state)
	{
		this.zip = zip;
		this.lat = lat;
		this.lon = lon;
		this.name = name;
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public double getLat()
	{
		return lat;
	}

	public double getLon()
	{
		return lon;
	}

	public String getName()
	{
		return name;
	}

	public String getState()
	{
		return state;
	}

	@Override
	public String toString()
	{
		return "City [zip=" + zip + ", lat=" + lat + ", lon=" + lon + ", name=" + name + ", state=" + state + "]";
	}
}
