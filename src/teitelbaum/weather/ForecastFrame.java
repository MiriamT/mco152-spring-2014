package teitelbaum.weather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForecastFrame extends JFrame
{
	private final JButton submitButton;
	private final JTextField textbox;
	private final ForecastGraph graph;

	public ForecastFrame()
	{
		graph = new ForecastGraph();
		add(graph);

		setSize(800, 300);
		setTitle("Forecast");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		textbox = new JTextField(30);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter location as 'city' or 'city,state' : "));
		panel.add(textbox);
		add(BorderLayout.NORTH, panel);

		final ForecastFrame frame = this;
		submitButton = new JButton("submit");
		submitButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String text = textbox.getText();
				if (text != null && !"".equals(text))
				{
					FetchForecastThread thread = new FetchForecastThread(text.trim(), "http://api.openweathermap.org/data/2.5/forecast?q=", frame, graph);
					thread.start();
				}

			}
		});
		add(BorderLayout.SOUTH, submitButton);

	}

	public static void main(String[] args) throws IOException
	{
		ForecastFrame frame = new ForecastFrame();
		frame.setVisible(true);
	}
}
