package teitelbaum.weather;

import com.google.gson.annotations.SerializedName;

public class Main
{
	private double temp;
	private double humidity;
	private double pressure;
	@SerializedName("temp_min")
	private double tempMin;
	@SerializedName("temp_max")
	private double tempMax;

	public double getTemp()
	{
		return temp;
	}

	public double getHumidity()
	{
		return humidity;
	}

	public double getPressure()
	{
		return pressure;
	}

	public double getTempMin()
	{
		return tempMin;
	}

	public double getTempMax()
	{
		return tempMax;
	}

	@Override
	public String toString()
	{
		return "\nTemperature: " + temp + "\nhumidity: " + humidity + "\n pressure " + pressure + "\ntempMin: " + tempMin + "\ntempMax: " + tempMax;
	}

}
