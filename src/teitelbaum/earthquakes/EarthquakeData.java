package teitelbaum.earthquakes;

public class EarthquakeData 
{
	private String location;
	private double magnitude;
	
	public String getLocation() {
		return location;
	}
	public double getMagnitude() {
		return magnitude;
	}
	@Override
	public String toString() {
		return magnitude + " " + location;
	}
}
