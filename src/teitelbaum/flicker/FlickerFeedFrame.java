package teitelbaum.flicker;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scroll;
	private JLabel[] labels;
	
	public FlickerFeedFrame() 
	{
		setSize(800, 350);
		setTitle("Flicker Pictures");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel = new JPanel();
		labels = new JLabel[20];
		for (int i = 0; i < 20; i++)
		{
			labels[i] = new JLabel();
			panel.add(labels[i]);
		}
		scroll = new JScrollPane(panel);
		add(scroll);
		
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(this);
		thread.start();
	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) 
	{
		Item[] items = feed.getItems();
		for (int i = 0; i < items.length; i++)
		{
			DownloadImageThread t = new DownloadImageThread(labels[i], items[i].getMedia().getM());
			t.start();
		}
	}

	public static void main(final String args[])
	{
		new FlickerFeedFrame().setVisible(true);
	}

}
