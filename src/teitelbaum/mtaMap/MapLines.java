package teitelbaum.mtaMap;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

public class MapLines extends JComponent
{
	private final List<Line> lines;
	private final Convertor convertor;

	public MapLines(List<Line> lines, MapFrame window, Shapes s)
	{
		this.lines = lines;
		convertor = new Convertor(window, s);
	}

	@Override
	public void paintComponent(Graphics g)
	{
		for (Line l : lines)
		{
			if (l.getColor() != null)
			{
				l.draw(convertor, g);
			}
		}
	}
}
