package teitelbaum.earthquakes;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DownloadQuakesThread extends Thread {
	private static final String FEED_URL = "http://earthquake-report.com/feeds/recent-eq?json";
	private EarthquakeList quakes;
	private ShowEarthquakes window;

	public DownloadQuakesThread(ShowEarthquakes window) {
		this.window = window;
	}

	@Override
	public void run() {
		super.run();
		Gson gson = new Gson();
		while (true) 
		{
			try 
			{
				URL url = new URL(FEED_URL);
				URLConnection connection = url.openConnection();
				InputStream in = connection.getInputStream();

				final JsonReader jsonReader = new JsonReader(
						new InputStreamReader(in));
				jsonReader.setLenient(true);
				//jsonReader.nextString();

				quakes = gson.fromJson(jsonReader, EarthquakeList.class);
				window.refresh(quakes);
			} 
			catch (IOException e) 
			{
			}
			try {
				sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
