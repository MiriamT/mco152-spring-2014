package teitelbaum.weather;

import java.awt.Graphics;

import javax.swing.JComponent;

public class ForecastGraph extends JComponent
{
	private Forecast forecast;

	public ForecastGraph()
	{
		forecast = null;
	}

	public void setForecast(Forecast f)
	{
		forecast = f;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if (forecast != null)
		{
			List[] lists = forecast.getList();
			int height = getHeight();
			int xSectionLength = getWidth() / lists.length;

			for (int i = 1; i < lists.length; i++)
			{
				g.drawLine((i - 1) * xSectionLength, height - (int) lists[i - 1].getMain().getTemp(), i * xSectionLength, height - (int) lists[i].getMain().getTemp());
			}
		}

	}

}
