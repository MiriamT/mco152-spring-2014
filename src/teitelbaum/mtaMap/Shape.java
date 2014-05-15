package teitelbaum.mtaMap;

public class Shape
{
	private String shapeID;
	private double lat;
	private double lon;

	public Shape(String shapeID, double lat, double lon)
	{
		this.shapeID = shapeID;
		this.lat = lat;
		this.lon = lon;
	}

	public String getShapeID()
	{
		return shapeID;
	}

	public double getLat()
	{
		return lat;
	}

	public double getLon()
	{
		return lon;
	}
}
