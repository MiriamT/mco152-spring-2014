package teitelbaum.mtaMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MapFrame extends JFrame
{
	public MapFrame() throws IOException
	{
		setSize(800, 800);
		setTitle("MTA Map");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Shapes s = new Shapes();
		Trips t = new Trips();
		Routes r = new Routes();
		List<String> shapeIds = s.getShapeIDs();
		ArrayList<Line> lines = new ArrayList<Line>();
		for (String id : shapeIds)
		{
			lines.add(new Line(id, s, t, r));
		}
		add(new MapLines(lines, this, s));
	}

	public static void main(String[] args)
	{
		try
		{
			MapFrame map = new MapFrame();
			map.setVisible(true);
		}
		catch (IOException io)
		{
			JOptionPane.showMessageDialog(null, "error loading map data");
		}
	}
}
