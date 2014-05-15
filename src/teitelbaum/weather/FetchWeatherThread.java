package teitelbaum.weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class FetchWeatherThread extends Thread
{
	private final String location;
	private final String baseURL;
	private WeatherCondition condition;
	private final WeatherFrame window;

	public FetchWeatherThread(String location, String baseURL, WeatherFrame frame)
	{
		this.location = location;
		this.baseURL = baseURL;
		condition = null;
		window = frame;
	}

	@Override
	public void run()
	{
		Gson gson = new Gson();
		try
		{
			URL url = new URL(baseURL + location + "&mode=json&units=imperial");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			condition = gson.fromJson(new InputStreamReader(in), WeatherCondition.class);
		}
		catch (IOException e)
		{
			condition = null;
		}
		window.getWeatherText().setText(condition.toString());
	}

	public WeatherCondition getCondition()
	{
		return condition;
	}

}
