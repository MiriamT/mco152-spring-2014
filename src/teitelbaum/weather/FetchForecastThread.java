package teitelbaum.weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class FetchForecastThread extends Thread
{
	private final String location;
	private final String baseURL;
	private Forecast forecast;
	private final ForecastFrame window;
	private final ForecastGraph graph;

	public FetchForecastThread(String location, String baseURL, ForecastFrame frame, ForecastGraph graph)
	{
		this.location = location;
		this.baseURL = baseURL;
		forecast = null;
		window = frame;
		this.graph = graph;
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
			forecast = gson.fromJson(new InputStreamReader(in), Forecast.class);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			forecast = null;
		}

		graph.setForecast(forecast);
		window.repaint();
	}

	public Forecast getForecast()
	{
		return forecast;
	}
}
