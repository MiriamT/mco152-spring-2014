package teitelbaum.nasa;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DownloadNasaFeedThread extends Thread 
{
	//private static final String FEED_URL = "http://merpublic.s3.amazonaws.com/oss/mera/images/images_sol6.json";
	private NasaFrame window;
	private String SolUrl;

	public DownloadNasaFeedThread(NasaFrame window, String url) {
		this.window = window;
		SolUrl = url;
	}

	@Override
	public void run() {
		super.run();
		Gson gson = new Gson();
		try {
			URL url = new URL(SolUrl);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();

			final JsonReader jsonReader = new JsonReader(new InputStreamReader(
					in));
			jsonReader.setLenient(true);

			NasaFeed feed = gson.fromJson(jsonReader, NasaFeed.class);

			ArrayList<Image> images = new ArrayList<>();

			Camera[][] cameras = { feed.getPcam(), feed.getNcam(),
					feed.getFcam(), feed.getRcam() };
			for (Camera[] cam : cameras) {
				for (Camera c : cam) {
					for (Image i : c.getImages()) {
						images.add(i);
					}
				}
			}

			window.populateList(images);

			window.setTitle(feed.getMission() + " Sol(" + feed.getSol() + ") "
					+ images.size());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
