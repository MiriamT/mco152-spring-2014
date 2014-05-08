package teitelbaum.flicker;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread 
 {
	private JLabel label;
	private String urlString;

	public DownloadImageThread(final JLabel label, final String url) 
	{
		this.label = label;
		this.urlString = url;
	}

	@Override
	public void run() 
	{
		super.run();
		
		try 
		{
		    URL url = new URL(urlString);
		    Image image = ImageIO.read(url);
		    ImageIcon icon = new ImageIcon(image); 
		    label.setIcon(icon);
		} 
		catch (IOException e) 
		{
		}
	}
}
