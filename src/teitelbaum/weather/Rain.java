package teitelbaum.weather;

import com.google.gson.annotations.SerializedName;

public class Rain
{
	@SerializedName("3h")
	private double past3Hours;

	@Override
	public String toString()
	{
		return "Rainfall in past 3 Hours: " + past3Hours;
	}

	public double getPast3Hours()
	{
		return past3Hours;
	}
}
