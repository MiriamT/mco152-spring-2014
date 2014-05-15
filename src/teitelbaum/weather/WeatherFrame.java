package teitelbaum.weather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WeatherFrame extends JFrame
{
	private final JButton submitButton;
	private final JTextField textbox;
	private final JTextArea weatherText;

	public WeatherFrame()
	{
		setSize(800, 600);
		setTitle("Weather");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		textbox = new JTextField(30);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter location as 'city' or 'city,state' : "));
		panel.add(textbox);
		add(BorderLayout.NORTH, panel);

		weatherText = new JTextArea("");
		add(BorderLayout.CENTER, weatherText);

		final WeatherFrame frame = this;
		submitButton = new JButton("submit");
		submitButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String text = textbox.getText();
				if (text != null && !"".equals(text))
				{
					text.trim();
					FetchWeatherThread thread = new FetchWeatherThread(text, "http://api.openweathermap.org/data/2.5/weather?q=", frame);
					thread.start();
				}

			}
		});
		add(BorderLayout.SOUTH, submitButton);
	}

	public JTextArea getWeatherText()
	{
		return weatherText;
	}

	public static void main(String[] args) throws IOException
	{
		WeatherFrame frame = new WeatherFrame();
		frame.setVisible(true);
	}

}
