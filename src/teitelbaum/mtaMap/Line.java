package teitelbaum.mtaMap;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Line
{
	private final List<Shape> lineShapes;
	private Color color;
	private final String routeID;

	public Line(String shapeID, Shapes shapes, Trips trips, Routes routes)
	{
		lineShapes = shapes.getShapes(shapeID);
		routeID = trips.getRouteID(shapeID);
		color = routes.getColor(routeID);
	}

	public List<Shape> getLineShapes()
	{
		return lineShapes;
	}

	public String getRouteID()
	{
		return routeID;
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color c)
	{
		color = c;
	}

	public void draw(Convertor c, Graphics g)
	{
		g.setColor(color);
		int x1, y1, x2, y2;
		for (int i = 0; i < lineShapes.size() - 1; i++)
		{
			y1 = (int) c.convertLatToY(lineShapes.get(i).getLat());
			x1 = (int) c.convertLontoX(lineShapes.get(i).getLon());
			y2 = (int) c.convertLatToY(lineShapes.get(i + 1).getLat());
			x2 = (int) c.convertLontoX(lineShapes.get(i + 1).getLon());
			g.drawLine(x1, y1, x2, y2);
		}
	}

}
