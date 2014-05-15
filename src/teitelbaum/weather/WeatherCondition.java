package teitelbaum.weather;

import java.util.Arrays;

public class WeatherCondition
{

	private Coord coord;
	private Sys sys;
	private Weather[] weather;
	private String base;
	private Main main;
	private Wind wind;
	private Clouds clouds;
	private Rain rain;
	private long dt;
	private long id;
	private String name;
	private int cod;

	public Coord getCoord()
	{
		return coord;
	}

	public Sys getSys()
	{
		return sys;
	}

	public Weather[] getWeather()
	{
		return weather;
	}

	public String getBase()
	{
		return base;
	}

	public Main getMain()
	{
		return main;
	}

	public Wind getWind()
	{
		return wind;
	}

	public Clouds getClouds()
	{
		return clouds;
	}

	public Rain getRain()
	{
		return rain;
	}

	public long getDt()
	{
		return dt;
	}

	public long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public int getCod()
	{
		return cod;
	}

	@Override
	public String toString()
	{
		return "WeatherCondition:" + coord + sys + Arrays.toString(weather) + base + main + wind + clouds + "\n" + rain + "\n" + dt + "\n" + id + "\n" + name + "\n" + cod;
	}

}
