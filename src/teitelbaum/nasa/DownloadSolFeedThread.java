package teitelbaum.nasa;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class DownloadSolFeedThread extends Thread {
	private static final String FEED_URL = "https://merpublic.s3.amazonaws.com/oss/mera/images/image_manifest.json";
	private NasaFrame window;

	public DownloadSolFeedThread(NasaFrame window) {
		this.window = window;
	}

	@Override
	public void run() {
		super.run();
		Gson gson = new Gson();
		try {
			URL url = new URL(FEED_URL);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();

			final JsonReader jsonReader = new JsonReader(new InputStreamReader(
					in));
			jsonReader.setLenient(true);

			SolFeed feed = gson.fromJson(jsonReader, SolFeed.class);

			Sol[] sols = feed.getSols();
			window.loadComboBox(sols);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
