package teitelbaum.weather;

import java.util.Arrays;

public class Forecast
{
	private List[] list;

	@Override
	public String toString()
	{
		return "Forecast [list=" + Arrays.toString(list) + "]";
	}

	public List[] getList()
	{
		return list;
	}

}
