package teitelbaum.flicker;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 * downloads flicker feed as flickerFeed object
 * 1. connect to URL and download
 * 2. call method in frame
 */
public class DownloadFlickerFeedThread extends Thread 
{
	private static final String	FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";
	private FlickerFeed feed;
	private FlickerFeedFrame frame;
	
	public DownloadFlickerFeedThread(final FlickerFeedFrame frame) 
	{
		this.frame = frame;
	}

	@Override
	public void run() 
	{
		super.run();
		Gson gson = new Gson();
		try
		{
			URL url = new URL(FEED_URL);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			
			final JsonReader jsonReader = new JsonReader(new InputStreamReader(in));
			jsonReader.setLenient(true);
			jsonReader.nextString();
			
			feed = gson.fromJson(jsonReader, FlickerFeed.class);
			frame.loadImages(feed);
		}
		catch (IOException e)
		{
		}
	}

}
