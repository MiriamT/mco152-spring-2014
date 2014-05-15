package teitelbaum.weather;

public class Weather
{
	private int id;
	private String main;
	private String description;
	private String icon;

	@Override
	public String toString()
	{
		return "\nWeather: " + main + ", " + description + ", icon=" + icon + "]";
	}

	public int getId()
	{
		return id;
	}

	public String getMain()
	{
		return main;
	}

	public String getDescription()
	{
		return description;
	}

	public String getIcon()
	{
		return icon;
	}
}
